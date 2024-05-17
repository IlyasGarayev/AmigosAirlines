package TicketManager;

import java.util.Date;
import java.util.List;

public class Ticket {
    private String id;
    private String fullName;
    private String origin;
    private String destination;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    private Date flightDate;

    public Ticket(String id, String fullName, String origin, String destination, Date flightDate) {
        this.id = id;
        this.fullName = fullName;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
    }
}
