package LogInAndRegister;

import ChainLogic.Chain;
import LogInAndRegister.Login.LoginForAdmin;
import LogInAndRegister.Login.LoginManager;
import LogInAndRegister.Register.RegisterManager;
import SecurityCheck.InputChecker;
import User.User;

import java.util.Scanner;

public class LogInAndRegisterForm extends Chain {

    @Override
    public void process(User user) {
        System.out.println("Amigos Airlines tətbiqinə xoş gəlmisiniz!");
        System.out.println("1) Log in\n2) Register\n0) Exit");

        LoginManager loginManager = new LoginManager();
        RegisterManager registerManager = new RegisterManager();
        LoginForAdmin loginForAdmin = new LoginForAdmin();

        //Scanner scanner = new Scanner(System.in);
        int choice = new InputChecker().choiceChecker(3);


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
            case 1 -> setNext(new LoginManager());
            case 2 -> setNext(new RegisterManager());
            case 3 -> setNext(new LoginForAdmin());
        }
    }
}
