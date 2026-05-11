import Application.materialService;
import Application.productService;
import Domain.recyclingGuidance;
import Domain.simpleSumStrategy;
import Presentation.consoleUi;

public class Main {

    public static void main(String[] args) {
        simpleSumStrategy strategy = new simpleSumStrategy();
        productService productService = new productService(strategy);
        materialService materialService = new materialService();
        recyclingGuidance recyclingGuidance = new recyclingGuidance();

        consoleUi ui = new consoleUi(productService, materialService, recyclingGuidance);
        ui.menuLoop();
    }
}