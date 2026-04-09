package Domain;

import java.util.ArrayList;
import java.util.List;

public class Product{

    // need to add usage of materials in product, and maybe also usage history for better impact calculation and recycling guidance
    
    private String name;
    private String type;
    private int lifespan;
    private List<String> materials;

    public Product(String name, String type, int lifespan, List<String> materials){
        this.name = name;
        this.type = type;
        this.lifespan = lifespan;
        this.materials = materials;
    }


    public String getInfo(){
        
        return "Test";

    }
}