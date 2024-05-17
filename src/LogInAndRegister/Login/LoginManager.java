package LogInAndRegister.Login;

import FileManager.FileUsers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginManager implements LoginService {

    @Override
    public void login() {



        System.out.println("Logine Xos Gelmisiniz !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gmailinizi daxil edin -> ");
        String gmail = scanner.nextLine();
        System.out.println("Passwordunuzu daxil edin -> ");
        String password = scanner.nextLine();
        scanner.close();

        try {
            Path filePath = Paths.get("src/Datas/users.txt");
            //Files.createDirectories(filePath.getParent());
            FileUsers searchInFile = new FileUsers(filePath);
            String foundRecord = searchInFile.search("gmail", gmail);
            if (!foundRecord.isEmpty()) {
                String[] elements = foundRecord.trim().split(";");

                if(elements[searchInFile.getIndex("password")].equals(password)) {
                    System.out.println("Hesaba daxil olundu");
                    return;
                }

                System.out.println("Etibarsiz Sifre!");
            } else {
                System.out.println("Istifadeci tapilmadi!");
            }
        } catch (IOException e) {
            System.err.println("Giriş zamanı xəta baş verdi: " + e.getMessage());
        }
    }
}

