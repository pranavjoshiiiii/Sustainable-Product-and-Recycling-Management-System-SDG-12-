package src.main.java.Domain;

public class material {

    private String name;
    private double impactValue;
    private String instructions;
    private recyclingCategory recyclingCategory;

    public material(String name, double impactValue, String instructions, recyclingCategory recyclingCategory) {
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

    public recyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}
