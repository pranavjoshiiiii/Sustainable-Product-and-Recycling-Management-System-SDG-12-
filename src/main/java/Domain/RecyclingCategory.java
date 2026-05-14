package Domain;

public enum RecyclingCategory {
    GENERAL("General Waste", "Mixed materials"),
    PLASTIC("Plastic", "Polymer-based materials"),
    METAL("Metal", "Metallic materials"),
    GLASS("Glass", "Glass-based materials"),
    ORGANIC("Organic", "Biodegradable materials");

    private String label;
    private String materialComposition;

    RecyclingCategory(String label, String materialComposition) {
        this.label = label;
        this.materialComposition = materialComposition;
    }

    public String getLabel() {
        return label;
    }

    public String getMaterialComposition() {
        return materialComposition;
    }
}