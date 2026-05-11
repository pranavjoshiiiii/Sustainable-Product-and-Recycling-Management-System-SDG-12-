package Domain;

public class user {

    private String name;
    private String email;
    private String credentials;

    public user(String name, String email, String credentials) {
        this.name = name;
        this.email = email;
        this.credentials = credentials;
    }

    public String getInfo() {
        return name + " - " + email;
    }
}
