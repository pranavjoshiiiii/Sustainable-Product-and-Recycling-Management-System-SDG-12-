package src.main.java.Presentation;

import src.main.java.Application.materialService;
import src.main.java.Application.productService;
import src.main.java.Domain.product;
import src.main.java.Domain.recyclingGuidance;

import java.util.List;
import java.util.Scanner;

public class consoleUi {

    private productService productService;
    private materialService materialService;
    private recyclingGuidance recyclingGuidance;
    private Scanner scanner;

    public consoleUi(productService productService, materialService materialService, recyclingGuidance recyclingGuidance) {
        this.productService = productService;
        this.materialService = materialService;
        this.recyclingGuidance = recyclingGuidance;
        this.scanner = new Scanner(System.in);
    }

    public void menuLoop() {
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                addProduct();
            } else if (choice == 2) {
                listProducts();
            } else if (choice == 3) {
                addMaterial();
            } else if (choice == 4) {
                listMaterials();
            } else if (choice == 5) {
                calculateImpact();
            } else if (choice == 6) {
                showRecyclingGuidance();
            } else if (choice == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }

    public void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Add Product");
        System.out.println("2. List Products");
        System.out.println("3. Add Material");
        System.out.println("4. List Materials");
        System.out.println("5. Calculate Impact");
        System.out.println("6. Recycling Guidance");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void printOutput(String message) {
        System.out.println(message);
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product type: ");
        String type = scanner.nextLine();

        System.out.print("Enter lifespan in years: ");
        int lifespan = Integer.parseInt(scanner.nextLine());

        productService.createProduct(name, type, lifespan);
        System.out.println("Product added!");
    }

    private void listProducts() {
        List<product> products = productService.listProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (product p : products) {
                System.out.println(productService.getDetails(p));
            }
        }
    }

    private void addMaterial() {
        System.out.print("Enter material name: ");
        String name = scanner.nextLine();

        System.out.print("Enter impact value: ");
        double impactValue = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter recycling instructions: ");
        String instructions = scanner.nextLine();

        materialService.createMaterial(name, impactValue, instructions);
        System.out.println("Material added!");
    }

    private void listMaterials() {
        var materials = materialService.listMaterials();

        if (materials.isEmpty()) {
            System.out.println("No materials found.");
        } else {
            for (var m : materials) {
                System.out.println(materialService.getMaterialDetails(m));
            }
        }
    }

    private void calculateImpact() {
        List<product> products = productService.listProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Select a product:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getInfo());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        product selected = products.get(choice);
        double impact = productService.calculateImpact(selected);
        System.out.println("Impact score: " + impact);
    }

    private void showRecyclingGuidance() {
        List<product> products = productService.listProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Select a product:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getInfo());
        }

        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        product selected = products.get(choice);
        System.out.println(recyclingGuidance.guidance(selected));
    }
}