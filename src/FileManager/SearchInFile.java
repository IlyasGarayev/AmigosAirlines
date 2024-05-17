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
        System.out.println("Basladi");
        int index = getIndex(key);
        if (index == -1) return "";
        try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(";");
                if (index <= elements.length && elements[index].trim().equals(value)) {
                    return line;
                }
            }
        }
        return "";
    }

    public abstract int getIndex(String key);
}
