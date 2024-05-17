package TicketManager;

import ChainLogic.Chain;
import FileManager.FileFlights;
import Flight.Flight;
import Flight.FlightManager;
import User.User;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
        user.setDesiredFlight(flight);
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
            Path path = Paths.get("src/Datas/flights.txt");
             FileFlights searchInFile = new FileFlights(path);
             String line = searchInFile.search("originAndDestination", origin + destination);
             if(line != null){
                 String[] elemets = line.trim().split(";");
                 String dateString = elemets[searchInFile.getIndex("flightTime")];
                 SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

                 try {
                     Date date = formatter.parse(dateString);
                     Flight flight = new Flight(
                             elemets[searchInFile.getIndex("flightNumber")],
                             origin+destination,
                             Integer.parseInt(elemets[searchInFile.getIndex("capacity")]),
                             date
                     );
                     return flight;
                 } catch (ParseException e) {
                     e.printStackTrace();
                 }
             }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return null;
    }

}
