import Application.MaterialService;
import Application.ProductService;
import Domain.RecyclingGuidance;
import Domain.SimpleSumStrategy;
import Presentation.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        ProductService productService = new ProductService(strategy);
        MaterialService materialService = new MaterialService();
        RecyclingGuidance recyclingGuidance = new RecyclingGuidance();

        ConsoleUI ui = new ConsoleUI(productService, materialService, recyclingGuidance);
        ui.menuLoop();
    }
}