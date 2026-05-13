

import java.util.List;
import java.util.Scanner;

import src.main.java.Application.materialService;
import src.main.java.Application.productService;
import src.main.java.Application.strategyFactory;
import src.main.java.Domain.impactCalculationStrategy;
import src.main.java.Domain.recyclingGuidance;
import src.main.java.Presentation.consoleUi;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<impactCalculationStrategy> strategies = strategyFactory.getAvailableStrategies();

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

        impactCalculationStrategy strategy = strategyFactory.create(choice);
        productService productService = new productService(strategy);
        materialService materialService = new materialService();
        recyclingGuidance recyclingGuidance = new recyclingGuidance();

        consoleUi ui = new consoleUi(productService, materialService, recyclingGuidance);
        ui.menuLoop();
    }
}