package Register;

import FileManager.WriteFile;
import Register.RegisterService;
import User.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterManager implements RegisterService {
    private User user;

    public RegisterManager(User user) {
        this.user = user;
    }
    public RegisterManager(){

    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registra Xos Gelmisiniz !");
        System.out.print("Adinizi daxil edin -> ");
        String name = scanner.nextLine();
        user.setName(name);
        System.out.print("Soyadinizi daxil edin -> ");
        String lastName = scanner.nextLine();
        user.setLastname(lastName);
        System.out.print("Identity Numberinizi daxil edin -> ");
        String identityNumber = scanner.nextLine();
        System.out.print("Gmailinizi daxil edin -> ");
        String gmail = scanner.nextLine();
        System.out.print("Passwordunuzu daxil edin -> ");
        String password = scanner.nextLine();

        if (!isValidIdentityNumber(identityNumber)) {
            System.out.println("Identity number is invalid!");
        } else {
            user.setIdentityNumber(identityNumber);
        }

        if (!isValidEmail(gmail)) {
            System.out.println("Email address is invalid!");
        } else {
            user.setGmail(gmail);
        }

        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters long!");
        } else {
            user.setPassword(password);
        }
        WriteFile writeFile = new WriteFile();
        writeFile.fileYaz("src/Datas/users.txt",user.toString());
    }

    private static boolean isValidIdentityNumber(String identityNumber) {
        return identityNumber != null && identityNumber.length() >= 7;
    }

    private static boolean isValidEmail(String email) {
        if (email == null)
            return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}



