package Domain;

public class User {

    private String name;
    private String email;

    public User(String name, String email, String credentials) {
        this.name = name;
        this.email = email;
    }

    public String getInfo() {
        return name + " - " + email;
    }
}
