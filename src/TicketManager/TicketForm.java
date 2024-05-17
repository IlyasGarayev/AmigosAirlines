package TicketManager;

import ChainLogic.Chain;
import Flight.Flight;
import Flight.FlightManager;
import User.User;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TicketForm extends Chain {


    @Override
    public void process(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Haradan: ");
        String origin = scanner.nextLine();
        System.out.println("Haraya: ");
        String destination = scanner.nextLine();
        Flight flight = findFlight(origin, destination);

        if(flight != null){
            System.out.println("Bilet tapildi");
            System.out.println(origin + " - " + destination);
            System.out.println("Date: "); // Duzeldilecek...
            System.out.println("Time: ");

        }
        else{
            System.out.println("Qeyd etdiyiniz istiqametde ucus tapilmadi.");
        }
    }

    private Flight findFlight(String origin, String destination) {
        try {
            Path path = Paths.get("src/Datas/flights");
            // FileFlights searchInFile = new FileFlights(path);
            // String line = searchInFile.search("origin-destination", origin + "-" + destination);
            // if(line != null){
            //     String[] elemets = line.trim().split(";");
            //     Flight flight = new Flight(
            //          elemets[seachInFile.getIndex("flightNumber")],
            //          elemets[seachInFile.getIndex("origin-destination")],
            //          elemets[seachInFile.getIndex("capacity")],
            //          elemets[seachInFile.getIndex("bookedSeats")],
            //          elemets[seachInFile.getIndex("flightTime")],
            //     );
            //     return flight;
            // }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return null;
    }

}
