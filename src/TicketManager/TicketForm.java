package TicketManager;

import CardDetails.CardForm;
import ChainLogic.Chain;
import FileManager.FileFlights;
import Flight.Flight;
import Flight.FlightManager;
import MainPage.ManagerPage;
import SecurityCheck.InputChecker;
import User.User;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicketForm extends Chain {


    @Override
    public void process(User user) {
        System.out.println("Haradan: ");

        Scanner scanner = new Scanner(System.in);
        String origin = scanner.nextLine();
        System.out.println("Haraya: ");
        String destination = scanner.nextLine();
        Flight flight = findFlight(origin, destination);
        user.setDesiredFlight(flight);
        if(flight != null){
            System.out.println("Bilet tapildi");
            System.out.println(origin + " - " + destination);
            System.out.println("Date: " + flight.getFlightTime()); // Duzeldilecek...
            System.out.println("Price: " + new Random().nextInt(100,1000) + "$");
            setNext(new CardForm());

        }
        else{
            System.out.println("Qeyd etdiyiniz istiqametde ucus tapilmadi.\n");
            mainPageOrTryAgain();
        }
    }

    private void mainPageOrTryAgain(){
        System.out.println("1) Yeniden bilet axtar\n2) Ana sehifeye qayit\n0) Exit");
        //Scanner scanner = new Scanner(System.in);
        int choice = new InputChecker().choiceChecker(2);

        switch (choice){
            case 0 -> {
                System.out.println("Programdan cixilir...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.exit(0);
            }
            case 1 -> setNext(new TicketForm());
            case 2 -> setNext(new ManagerPage());
        }
    }

    private Flight findFlight(String origin, String destination) {
        try {
            Path path = Paths.get("src/Datas/flights.txt");
             FileFlights searchInFile = new FileFlights(path);
             String line = searchInFile.search("originAndDestination", origin + destination);
             if(!line.isEmpty()){
                 System.out.println(line);
                 String[] elemets = line.trim().split(";");
                 String dateString = elemets[searchInFile.getIndex("flightTime")];
                 SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);


                 Date date = formatter.parse(dateString);
                 Flight flight = new Flight(
                         elemets[searchInFile.getIndex("flightNumber")],
                         origin+destination,
                         Integer.parseInt(elemets[searchInFile.getIndex("capacity")]),
                         date
                 );

                 return flight;

             }else {
                 System.out.println("Ucus tapilmadi!!");

             }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return null;
    }

}
