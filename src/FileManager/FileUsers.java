package FileManager;

import java.nio.file.Path;

public class FileUsers extends SearchInFile{
    public FileUsers(Path path) {
        super(path);
    }

    @Override
    public int getIndex(String key) {
        switch  (key){
            case "name": return 0;
            case "lastname": return 1;
            case "identityNumber": return 2;
            case "password": return 3;
            case "gmail": return 4;
        }
        return -1;
    }
}
