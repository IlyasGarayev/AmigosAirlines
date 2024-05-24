package LogInAndRegister.Register;

import FileManager.WriteFile;
import User.User;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterManager implements RegisterService {
    private User user = new User();
    private boolean isRegisterValid = true;

    @Override
    public void register() {
        Path filePath = Paths.get("src/Datas/users.txt");
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
            isRegisterValid = false;
            System.out.println("Identity number is invalid!");
        } else {
            user.setIdentityNumber(identityNumber);
        }

        if (!isValidEmail(gmail)) {
            isRegisterValid = false;
            System.out.println("Email address is invalid!");
        } else {
            user.setGmail(gmail);
        }

        if (!isValidPassword(password)) {
            isRegisterValid = false;
            System.out.println("Password must be at least 8 characters long!");
        } else {
            user.setPassword(password);
        }
        try {
//            Files.createDirectories(filePath.getParent());
            if (!isRegisterValid){
                System.out.println("You couldn't register!");
            }else{
                WriteFile writeFile = new WriteFile(filePath);
                writeFile.write(user.toString());
                System.out.println("Registered successfully");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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


