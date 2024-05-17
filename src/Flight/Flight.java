package Flight;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private int bookedSeats;
    private Date flightTime;
    public Flight(){

    }
    public Flight(String flightNumber, String origin, String destination, int capacity, int bookedSeats,Date flightTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = bookedSeats;
        this.flightTime = flightTime;
    }



    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }
    @Override
    public String toString() {
        return "flightNumber='" + flightNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", capacity='" + capacity + '\'' +
                ", bookedSeats='" + bookedSeats + '\'' +
                ", flightTime='" + flightTime +'\'' + '\n'
                ;
    }
}
