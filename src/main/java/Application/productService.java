package Application;

import java.util.ArrayList;
import java.util.List;

import Domain.ImpactCalculationStrategy;
import Domain.Product;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private ImpactCalculationStrategy strategy;

    public ProductService(ImpactCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public void createProduct(String name, String type, int lifespan) {
        products.add(new Product(name, type, lifespan));
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
