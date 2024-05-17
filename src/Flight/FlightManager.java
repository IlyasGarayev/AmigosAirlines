package Flight;

import FileManager.ReadFile;
import FileManager.WriteFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FlightManager implements FlightService{
    private List<Flight> flights ;

    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public void add(Flight flight) {
        Path filePath = Paths.get("src/Datas/flights.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ucus nomrersini daxil edin -> ");
        String flightNumber = scanner.nextLine();

        System.out.print("Ucus baslama kordinatini teyin edin -> ");
        String origin = scanner.nextLine();

        System.out.print("Ucus teyinatinin kordinatini teyin edin -> ");
        String destination = scanner.nextLine();

        System.out.print("Bilet sayini teyin edin -> ");
        int capacity = Integer.parseInt(scanner.nextLine());

        System.out.print("Ucus vaxtini mueyyen edin (YYYY-MM-DD HH:mm) -> ");
        String flightTimeStr = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date flightTime = null;
        try {
            flightTime = formatter.parse(flightTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Flight newFlight = new Flight(flightNumber, origin, destination, capacity, 0,flightTime);

        flights.add(newFlight);
        try {
            Files.createDirectories(filePath.getParent());
            WriteFile writeFile = new WriteFile(filePath);
            writeFile.write(flight.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ucus ugurla elave olundu!");
    }

    @Override
    public void delete(Flight flight) {
        flights.remove(flight);
        System.out.println("Ucus silindi!");
    }

    @Override
    public void getAll() {

    }

    @Override
    public void update() {

    }
}
