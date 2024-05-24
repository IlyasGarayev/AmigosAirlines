package LogInAndRegister.Login;

import ChainLogic.Chain;
import User.User;

import java.util.Scanner;

public class LoginForAdmin extends Chain {
    @Override
    public void process(User user) {
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
