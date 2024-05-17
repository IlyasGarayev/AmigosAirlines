package FileManager;

import java.nio.file.Path;

public class FileUsers extends SearchInFile{
    public FileUsers(Path path) {
        super(path);
    }

    @Override
    public int getIndex(String key) {
        return switch (key) {
            case "name" -> 0;
            case "lastname" -> 1;
            case "identityNumber" -> 2;
            case "password" -> 3;
            case "gmail" -> 4;
            default -> -1;
        };
    }
}
