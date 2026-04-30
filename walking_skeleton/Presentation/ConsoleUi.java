import java.util.Scanner;
import walking_skeleton.Application.*;

public class ConsoleUi {

    ProductService service = new ProductService();
    Scanner sc = new Scanner(System.in);

    public void menuLoop() {
        while (true) {
            printMenu();
            String choice = readInput();

            if (choice.equals("1")) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter type: ");
                String type = sc.nextLine();

                System.out.print("Enter lifespan: ");
                String life = sc.nextLine();

                service.createProduct(name, type, life);

            } else if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    public void printMenu() {
        System.out.println("1. Create product");
        System.out.println("2. Exit");
    }

    public String readInput() {
        return sc.nextLine();
    }
}