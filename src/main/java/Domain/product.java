package Domain;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String name;
    private String type;
    private int lifespan;
    private List<Material> materials;

    public Product(String name, String type, int lifespan) {
        this.name = name;
        this.type = type;
        this.lifespan = lifespan;
        this.materials = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLifespan() {
        return lifespan;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public String getInfo() {
        return name + " (" + type + ") - lifespan: " + lifespan + " years";
    }
}