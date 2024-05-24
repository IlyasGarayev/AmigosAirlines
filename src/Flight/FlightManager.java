package Flight;

import FileManager.FileFlights;
import FileManager.WriteFile;
import TicketManager.TicketManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FlightManager implements FlightService{
    List<Flight> flights = new ArrayList<>();
    Path filePath = Paths.get("src/Datas/flights.txt");
    @Override
    public void add(Flight flight) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ucus nomrersini daxil edin -> ");
        String flightNumber = scanner.nextLine();
        flight.setFlightNumber(flightNumber);
        System.out.print("Ucus baslama kordinatini ve Sonunu teyin edin -> ");
        String originAndDestination = scanner.nextLine();
        flight.setOriginAndDestination(originAndDestination);
        System.out.print("Bilet sayini teyin edin -> ");
        int capacity = Integer.parseInt(scanner.nextLine());
        flight.setCapacity(capacity);
        System.out.print("Ucus vaxtini mueyyen edin (YYYY-MM-DD HH:mm) -> ");
        String flightTimeStr = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date flightTime = null;
        try {
            flightTime = formatter.parse(flightTimeStr);
            flight.setFlightTime(flightTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        try {
            WriteFile writeFile = new WriteFile(filePath);
            writeFile.write(flight.toString());
            TicketManager.allTickets.put(flight, new ArrayList<>());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ucus ugurla elave olundu!");
    }

    @Override
    public void delete() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Silenecek Flight Numberi daxil edin - > ");
        String flightNumber = scanner.nextLine();
        scanner.close();
        try {
            List<String> lines = Files.readAllLines(filePath);
            List<String> remainingLines = lines.stream()
                    .filter(line -> !line.startsWith(flightNumber + ";"))
                    .collect(Collectors.toList());
            Files.write(filePath, remainingLines);
            System.out.println(flightNumber + " nomreli ucus legv olundu !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll() {
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] parts = line.split(";");
                Flight flight = new Flight();
                flight.setFlightNumber(parts[0]);
                flight.setOriginAndDestination(parts[1]);
                flight.setCapacity(Integer.parseInt(parts[2]));
                SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                Date flightTime = formatter.parse(parts[3]);
                flight.setFlightTime(flightTime);
                flights.add(flight);
            }
            for (Flight flight : flights) {
                System.out.println(flight.toString());
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        String flightNumber = "";
        System.out.print("Update olunan Flight Numberi Daxil Edin ->  ");
        flightNumber = scanner.nextLine().trim();
        if (flightNumber.isEmpty()) {
            System.out.println("Flight Number cannot be empty. Please try again.");
            throw new NoSuchElementException("No line found");
        }

        try {
            List<String> lines = Files.readAllLines(filePath);
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.startsWith(flightNumber + ";")) {
                    found = true;
                    System.out.println("Yeni Melumatlari Daxil Et -> ");
                    Flight updatedFlight = new Flight();
                    updatedFlight.setFlightNumber(flightNumber);

                    System.out.print("Origin And Destination: ");
                    updatedFlight.setOriginAndDestination(scanner.nextLine());

                    System.out.print("Capacity: ");
                    int capacity = Integer.parseInt(scanner.nextLine());
                    updatedFlight.setCapacity(capacity);

                    System.out.print("Flight Time (YYYY-MM-DD HH:mm): ");
                    String flightTimeStr = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date flightTime = formatter.parse(flightTimeStr);
                    updatedFlight.setFlightTime(flightTime);

                    lines.set(i, updatedFlight.toString());

                    Files.write(filePath, lines);

                    System.out.println("Flight with number " + flightNumber + " updated successfully.");

                    break;
                }
            }

            if (!found) {
                System.out.println("Flight with number " + flightNumber + " not found.");
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
