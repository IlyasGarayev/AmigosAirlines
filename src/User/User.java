package User;

public class User {
    private int id;
    private String name;
    private String lastname;
    private Role role;
    private String identityNumber;
    private String password;
    public User(){

    }
    public User(int id, String name, String lastname, Role role, String identityNumber,String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.identityNumber = identityNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
