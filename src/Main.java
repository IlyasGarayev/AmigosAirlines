import LogInAndRegister.Login.LoginManager;
import LogInAndRegister.Login.LoginService;
import LogInAndRegister.Register.RegisterManager;
import LogInAndRegister.Register.RegisterService;
import User.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("----------------> Xos Gelmisiniz <---------------------\n");
        System.out.println("1)LogInAndRegister.Login \n");
        System.out.println("2)LogInAndRegister.Login.Register \n");
        RegisterService registerService = new RegisterManager(user);
        //registerService.register();
        LoginService loginService = new LoginManager();
        loginService.login();
    }
}