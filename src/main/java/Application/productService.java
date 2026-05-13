package src.main.java.Application;

import java.util.ArrayList;
import java.util.List;

import src.main.java.Domain.impactCalculationStrategy;
import src.main.java.Domain.product;


public class productService {
    private List<product> products = new ArrayList<>();
    private impactCalculationStrategy strategy;

    public productService(impactCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void createProduct(String name, String type, int lifespan) {
        products.add(new product(name, type, lifespan));
    }

    public List<product> listProducts() {
        return products;
    }

    public String getDetails(product product) {
        return product.getInfo();
    }

    public double calculateImpact(product product) {
        return strategy.calculateImpact(product);
    }
}
