import LogInAndRegister.LogInAndRegisterForm;
import User.User;

public class Main {
    public static void main(String[] args) {
        LogInAndRegisterForm logInAndRegisterForm = new LogInAndRegisterForm();
        logInAndRegisterForm.process(new User());
    }
}