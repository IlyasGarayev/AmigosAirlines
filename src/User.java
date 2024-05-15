public class User {
    private int id;
    private String name;
    private String lastname;
    private Role role;
    private String ficsalId;
    public User(){

    }
    public User(int id, String name, String lastname, Role role, String ficsalId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.ficsalId = ficsalId;
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

    public String getFicsalId() {
        return ficsalId;
    }

    public void setFicsalId(String ficsalId) {
        this.ficsalId = ficsalId;
    }
}
