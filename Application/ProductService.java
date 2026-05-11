package Application;

import java.util.ArrayList;
import java.util.List;
import Domain.Product;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private impactCalculationStrategy strategy;

    public ProductService(impactCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void createProduct(String name, String type, int lifespan) {
        products.add(new Product(name, type, lifespan, new ArrayList<>()));
    }

    public List<Product> listProducts() {
        return products;
    }

    public String getDetails(Product product) {
        return product.getInfo();
    }

    public double calculateImpact(Product product) {
        return strategy.calculateImpact(product);
    }
}
