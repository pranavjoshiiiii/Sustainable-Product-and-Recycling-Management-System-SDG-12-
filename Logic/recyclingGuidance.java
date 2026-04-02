package Logic;
import java.util.List;

import Domain.Product;

public class recyclingGuidance {

    public Product product;

    public recyclingGuidance(Product product){
        this.product = product;
    }

    public String guidance(Product product){
        return "Test guidance";
    }

    public String mixedMaterialRule(List<String> materials){
        return "Test mixed material rule";



    }
}


