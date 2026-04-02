package Domain;

public class recyclingCategory {

    private String lable;
    private String material;

    public recyclingCategory(String lable, String material){
        this.lable = lable;
        this.material = material;
    }

    public String getLable() {
        return lable;
    }

    public String getMaterial() {
        return material;
    }
    
}
