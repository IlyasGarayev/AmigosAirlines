package MainPage;

import ChainLogic.Chain;
import LogInAndRegister.LogInAndRegisterForm;
import SecurityCheck.InputChecker;
import TicketManager.TicketForm;
import User.User;

import java.util.Scanner;

public class ManagerPage extends Chain {
    private Scanner scanner;


    public ManagerPage(){

    }
    @Override
    public void process(User user) {
        /*
        1) Bilet al
        2) Biletlerim
        3) Exit
        */

        System.out.println("1) Bilet al");
        System.out.println("2) Hesabdan cix");
        System.out.println("0) Exit");
//        System.out.println("Seciminizi edin: ");

        InputChecker inputChecker = new InputChecker();
        int choice = inputChecker.choiceChecker(2);

        switch (choice) {
            case 0 -> {
                System.out.println("Programdan cixilir...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.exit(0);
            }
            case 1 -> {
                TicketForm ticketForm = new TicketForm();
                setNext(ticketForm);
            }
            case 2 -> {
                user = new User();
                setNext(new LogInAndRegisterForm());
            }
        }


    }
}
