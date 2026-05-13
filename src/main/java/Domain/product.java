package src.main.java.Domain;

import java.util.ArrayList;
import java.util.List;

public class product {

    private String name;
    private String type;
    private int lifespan;
    private List<material> materials;

    public product(String name, String type, int lifespan) {
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

    public List<material> getMaterials() {
        return materials;
    }

    public void addMaterial(material material) {
        materials.add(material);
    }

    public String getInfo() {
        return name + " (" + type + ") - lifespan: " + lifespan + " years";
    }
}