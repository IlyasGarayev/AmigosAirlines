package FileManager;

import java.io.IOException;
import java.nio.file.Path;

public class FileFlights extends SearchInFile{
    public FileFlights(Path path) {
        super(path);
    }
    @Override
    public int getIndex(String key) {
        return switch (key) {
            case "flightNumber" -> 0;
            case "originAndDestination" -> 1;
            case "capacity" -> 2;
            case "flightTime" -> 3;
            default -> -1;
        };
    }
}
