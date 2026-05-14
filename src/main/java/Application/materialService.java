package Application;

import java.util.ArrayList;
import java.util.List;

import Domain.Material;
import Domain.RecyclingCategory;

public class MaterialService {

    private List<Material> materials;

    public MaterialService() {
        this.materials = new ArrayList<>();
    }

    public void createMaterial(String name, double impactValue, String instructions) {
        Material material = new Material(name, impactValue, instructions, RecyclingCategory.GENERAL);
        materials.add(material);
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public List<Material> listMaterials() {
        return materials;
    }

    public String getMaterialDetails(Material material) {
        return material.getName() + " - impact: " + material.getImpactValue() + " - category: "
                + material.getRecyclingCategory().getLabel();
    }
}