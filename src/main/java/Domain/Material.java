package Domain;

public class Material {

    private String name;
    private double impactValue;
    private String instructions;
    private RecyclingCategory recyclingCategory;

    public Material(String name, double impactValue, String instructions, RecyclingCategory recyclingCategory) {
        this.name = name;
        this.impactValue = impactValue;
        this.instructions = instructions;
        this.recyclingCategory = recyclingCategory;
    }

    public String getName() {
        return name;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public String getInstructions() {
        return instructions;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}
