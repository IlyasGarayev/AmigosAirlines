package LogInAndRegister;

import ChainLogic.Chain;
import LogInAndRegister.Login.LoginManager;
import LogInAndRegister.Register.RegisterManager;
import SecurityCheck.InputChecker;
import User.User;

public class LogInAndRegisterForm extends Chain {
    LoginManager loginManager = new LoginManager();
    RegisterManager registerManager = new RegisterManager();
    @Override
    public void process(User user) {
        System.out.println("Amigos Airlines tətbiqinə xoş gəlmisiniz!");
        System.out.println("1) Log in\n2) Register\n0) Exit");
        int choice = new InputChecker().choiceChecker(2);


        switch (choice){
            case 0 -> {
                System.out.println("Programdan cixilir...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.exit(0);
            }
            case 1 -> loginManager.login(user);
            case 2 -> registerManager.register();
        }
    }
}
