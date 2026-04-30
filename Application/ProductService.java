package Application;

import Domain.ImpactCalculationStrategy;
import Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private ImpactCalculationStrategy strategy;
    private List<Product> products;

    public ProductService(ImpactCalculationStrategy strategy) {
        this.strategy = strategy;
        this.products = new ArrayList<>();
    }

    public void createProduct(String name, String type, int lifespan) {
        Product product = new Product(name, type, lifespan);
        products.add(product);
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
