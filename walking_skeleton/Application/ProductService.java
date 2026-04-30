package walking_skeleton.Application;
import walking_skeleton.Domain.Product;

public class ProductService {

    public void createProduct(String name, String type, String lifeSpan) {
        Product product = new Product(name, type, lifeSpan);

        System.out.println("Product created:");
        product.getInfo();
    }
}