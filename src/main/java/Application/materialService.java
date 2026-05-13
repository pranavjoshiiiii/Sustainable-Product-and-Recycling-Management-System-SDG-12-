package src.main.java.Application;

import java.util.ArrayList;
import java.util.List;

import src.main.java.Domain.material;
import src.main.java.Domain.recyclingCategory;

public class materialService {

    private List<material> materials;

    public materialService() {
        this.materials = new ArrayList<>();
    }

    public void createMaterial(String name, double impactValue, String instructions) {
        material material = new material(name, impactValue, instructions, recyclingCategory.GENERAL);
        materials.add(material);
    }

    public void addMaterial(material material) {
        materials.add(material);
    }

    public List<material> listMaterials() {
        return materials;
    }

    public String getMaterialDetails(material material) {
        return material.getName() + " - impact: " + material.getImpactValue() + " - category: " + material.getRecyclingCategory().getLabel();
    }
}