import LogInAndRegister.LogInAndRegisterForm;
import User.User;

public class Main {
    public static void main(String[] args) {
        LogInAndRegisterForm logInAndRegisterForm = new LogInAndRegisterForm();
        logInAndRegisterForm.doNext(new User());
    }
}