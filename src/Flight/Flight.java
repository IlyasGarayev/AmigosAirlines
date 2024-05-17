package Flight;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private String originAndDestination;
    private int capacity;
    private Date flightTime;
    public Flight(){

    }
    public Flight(String flightNumber, String originAndDestination, int capacity,Date flightTime) {
        this.flightNumber = flightNumber;
        this.originAndDestination = originAndDestination;
        this.capacity = capacity;
        this.flightTime = flightTime;
    }

    public String getOriginAndDestination() {
        return originAndDestination;
    }

    public void setOriginAndDestination(String originAndDestination) {
        this.originAndDestination = originAndDestination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }
    @Override
    public String toString() {
        return flightNumber + ";" +
                originAndDestination + ";" +
                capacity + ";" +
                flightTime +'\n';
    }
}
