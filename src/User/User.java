package User;

import Flight.Flight;

public class User {


    private int id;
    private String name;
    private String lastname;
    private String identityNumber;
    private String password;
    private String gmail;
    private Flight desiredFlight;

    public Flight getDesiredFlight() {
        return desiredFlight;
    }

    public void setDesiredFlight(Flight desiredFlight) {
        this.desiredFlight = desiredFlight;
    }

    public User(){

    }

    public User(int id, String name, String lastname, String identityNumber, String password, String gmail) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identityNumber = identityNumber;
        this.password = password;
        this.gmail = gmail;
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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    @Override
    public String toString() {
        return name + ";" +
                lastname + ";" +
                identityNumber + ";" +
                password + ";" +
                gmail + "\n";
    }
}
