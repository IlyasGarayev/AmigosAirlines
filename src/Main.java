import Login.LoginManager;
import Login.LoginService;
import Register.RegisterManager;
import Register.RegisterService;
import User.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("----------------> Xos Gelmisiniz <---------------------\n");
        System.out.println("1)Login \n");
        System.out.println("2)Register \n");
        RegisterService registerService = new RegisterManager(user);
        //registerService.register();
        LoginService loginService = new LoginManager();
        loginService.login();
    }
}