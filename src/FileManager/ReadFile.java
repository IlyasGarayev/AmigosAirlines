package FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readGmailAndPassword(String path) {
        List<String> gmailAndPassword = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValuePairs = line.split(",");
                for (String pair : keyValuePairs) {
                    String[] parts = pair.split("=");
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    if (key.equals("gmail") || key.equals("password")) {
                        gmailAndPassword.add(value);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return gmailAndPassword;
    }
}
