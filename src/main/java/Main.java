import java.util.List;
import java.util.Scanner;

import Application.MaterialService;
import Application.ProductService;
import Application.StrategyFactory;
import Domain.ImpactCalculationStrategy;
import Domain.RecyclingGuidance;
import Presentation.ConsoleUi;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<ImpactCalculationStrategy> strategies = StrategyFactory.getAvailableStrategies();

        System.out.println("Select impact calculation strategy:");
        for (int i = 0; i < strategies.size(); i++) {
            System.out.println((i + 1) + ". " + strategies.get(i).getClass().getSimpleName());
        }

        int choice = -1;
        while (choice < 1 || choice > strategies.size()) {
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }

        ImpactCalculationStrategy strategy = StrategyFactory.create(choice);
        ProductService productService = new ProductService(strategy);
        MaterialService materialService = new MaterialService();
        RecyclingGuidance recyclingGuidance = new RecyclingGuidance();

        ConsoleUi ui = new ConsoleUi(productService, materialService, recyclingGuidance);
        ui.menuLoop();
    }
}