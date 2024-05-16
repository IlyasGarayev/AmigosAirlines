package FileManager;

import java.nio.file.Path;

public class FileUsers extends SearchInFile{
    public FileUsers(Path path) {
        super(path);
    }

    @Override
    public int getIndex(String key) {
        switch (key){
            case "id": return 0;
            case "username": return 1;
            case "password": return 2;
        }
        return -1;
    }
}
