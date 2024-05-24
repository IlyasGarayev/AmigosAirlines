package LogInAndRegister.Login;

import FileManager.FileUsers;
import LogInAndRegister.LogInAndRegisterForm;
import User.User;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginManager extends LogInAndRegisterForm {


    public void login(User user) {

        System.out.println("Logine Xos Gelmisiniz !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gmailinizi daxil edin -> ");
        String gmail = scanner.nextLine();
        System.out.println("Passwordunuzu daxil edin -> ");
        String password = scanner.nextLine();
        //scanner.close();

        try {
            Path filePath = Paths.get("src/Datas/users.txt");
            FileUsers searchInFile = new FileUsers(filePath);
            String foundRecord = searchInFile.search("gmail", gmail);
            if (!foundRecord.isEmpty()) {
                String[] elements = foundRecord.trim().split(";");

                if(elements[searchInFile.getIndex("password")].equals(password)) {

                    System.out.println("Hesaba daxil olundu");

                    user.setName(elements[searchInFile.getIndex("name")]);
                    user.setLastname(elements[searchInFile.getIndex("lastname")]);
                    user.setIdentityNumber(elements[searchInFile.getIndex("identityNumber")]);
                    user.setGmail(elements[searchInFile.getIndex("gmail")]);
                    user.setPassword(elements[searchInFile.getIndex("password")]);

                    // setNext();

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

