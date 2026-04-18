package walking_skeleton.Domain;

public class Product {
    String name;
    String type;
    String lifeSpan;



    public Product(String name,String type,String lifeSpan){
        this.name = name;
        this.type = type;
        this.lifeSpan = lifeSpan;
    }
    public void getInfo(){
        System.out.println("Name:"+name);
        System.out.println("Type:"+type);
        System.out.println("Life Span:"+lifeSpan);
    }

}
