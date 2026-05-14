package Domain;

import java.util.List;

public class RecyclingGuidance {

    public String guidance(Product product) {
        String result = "Recycling guidance for " + product.getName() + ":\n";

        List<Material> materials = product.getMaterials();

        if (materials.isEmpty()) {
            result = result + "No materials registered for this product.";
            return result;
        }

        for (Material m : materials) {
            result = result + "- " + m.getName() + ": " + m.getInstructions() + "\n";
        }

        return result;
    }

    public String mixedMaterialRule(List<Material> materials) {
        if (materials.size() > 1) {
            return "This product contains mixed materials. Please separate before recycling.";
        }
        return "Single material product. Follow standard recycling instructions.";
    }
}