package Login;

import FileManager.ReadFile;
import User.User;

import java.util.List;
import java.util.Scanner;

public class LoginManager implements LoginService {


    @Override
    public void login() {
        System.out.println("Logine Xos Gelmisiniz !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gmailinizi daxil edin -> ");
        String gmail = "'" + scanner.nextLine() + "'";
        System.out.println("Passwordunuzu daxil edin -> ");
        String password ="'"+ scanner.nextLine() +"'";

        scanner.close();

        ReadFile reader = new ReadFile();
        List<String> gmailAndPassword = reader.readGmailAndPassword("users.txt");
        boolean loginSuccess = false;
        for (int i = 0; i < gmailAndPassword.size(); i += 2) {
            String userPassword = gmailAndPassword.get(i);
            String userGmail = gmailAndPassword.get(i + 1);

            if (password.equals(userPassword) && gmail.equals(userGmail)) {
                loginSuccess = true;
                break;
            }
        }

        if (loginSuccess) {
            System.out.println("Giriş Ugurla Basa Catdi!");
        } else {
            System.out.println("Giriş Ugursuz oldu. Xahis Olunur yeniden yoxlayin");
        }
    }
}
