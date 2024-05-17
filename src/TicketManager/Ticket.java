package TicketManager;

import java.util.Date;
import java.util.List;

public class Ticket {
    private String id;
    private String fullName;
    private String originAndDestination;
    private Date flightDate;


    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getOriginAndDestination() {
        return originAndDestination;
    }

    public Date getFlightDate() {
        return flightDate;
    }



    public Ticket(String id, String fullName, String originAndDestination, Date flightDate) {
        this.id = id;
        this.fullName = fullName;
        this.originAndDestination = originAndDestination;
        this.flightDate = flightDate;
    }
}
