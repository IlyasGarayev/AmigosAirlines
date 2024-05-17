package Login;

import FileManager.SearchInFile;
import Login.LoginService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginManager implements LoginService {

    @Override
    public void login() {
        Path filePath = Paths.get("users.txt");


        System.out.println("Logine Xos Gelmisiniz !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gmailinizi daxil edin -> ");
        String gmail = "'" + scanner.nextLine() + "'";
        System.out.println("Passwordunuzu daxil edin -> ");
        String password = "'" + scanner.nextLine() + "'";
        scanner.close();

        try {
            Files.createDirectories(filePath.getParent());
            SearchInFile searchInFile = new SearchInFile(filePath) {
                @Override
                public int getIndex(String key) {
                    switch (key) {
                        case "gmail":
                            return 4;
                        case "password":
                            return 3;
                        default:
                            return -1;
                    }
                }
            };
            String foundRecord = searchInFile.search("gmail", gmail);
            if (!foundRecord.isEmpty()) {
                String[] elements = foundRecord.split(",");
                for (String element : elements) {
                    String[] keyValue = element.split("=");
                    if (keyValue.length == 2 && keyValue[0].trim().equals("password") && keyValue[1].trim().equals(password)) {
                        System.out.println("Login Ugurlu Oldu!");
                        return;
                    }
                }
                System.out.println("Etibarsiz Sifre!");
            } else {
                System.out.println("Istifadeci tapilmadi!");
            }
        } catch (Exception e) {
            System.err.println("Giriş zamanı xəta baş verdi: " + e.getMessage());
        }
    }
}

