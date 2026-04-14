package Domain;

public class Material {
    private String name;
    private double impactValue;
    private String instructionns;
    private String recyclingCategory;

    public Material(String name, double impactValue, String instructions, String recyclingCategory){
        this.name = name;
        this.impactValue = impactValue;
        this.instructionns = instructions;
        this.recyclingCategory = recyclingCategory;
    }

    public String getName() {
        return name;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public String getInstructions() {
        return instructionns;
    }
    
    public String getRecyclingCategory() {
        return recyclingCategory;
    }
    
}
