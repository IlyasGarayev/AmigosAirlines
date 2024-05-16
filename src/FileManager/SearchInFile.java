package FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public abstract class SearchInFile {
    Path path;

    public SearchInFile(Path path) {
        this.path = path;
    }

    public String search(String key, String value) throws IOException {
        int index = getIndex(key);
        if(index == -1) return "";
        InputStream inputStream = Files.newInputStream(
                path,
                StandardOpenOption.READ
        );

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while( (line = bufferedReader.readLine()) != null){
             String[] elements = line.split(";");
             if(elements[index].equals(value)){
                 return line;  // Dc de danisariq
             }
        }
        return "";
    }

    public abstract int getIndex(String key);
}
