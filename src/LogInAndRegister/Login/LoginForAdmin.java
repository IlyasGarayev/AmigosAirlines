package LogInAndRegister.Login;

import java.util.Scanner;

public class LoginForAdmin implements LoginService{
    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username daxil edin -> ");
        String username = scanner.nextLine().trim();

        System.out.print("Passwordu daxil edin -> ");
        String password = scanner.nextLine().trim();

        if ("admin12345".equals(password) && "admin".equals(username)) {
            System.out.println("Login ugurla basa catdi.");
        } else {
            System.out.println("Username ve ya Passwordda problem var. Tekrar cehd edin !");
        }
    }

}
