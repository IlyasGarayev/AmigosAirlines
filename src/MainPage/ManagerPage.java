package MainPage;

import ChainLogic.Chain;
import LogInAndRegister.LogInAndRegisterForm;
import SecurityCheck.InputChecker;
import TicketManager.TicketForm;
import User.User;

public class ManagerPage extends Chain {
    @Override
    public void process(User user) {
        /*
        1) Bilet al
        2) Biletlerim
        3) Exit
        */

        System.out.println("1) Bilet al\n");
        System.out.println("2) Biletlerim\n");
        System.out.println("3) Hesabdan cix\n");
        System.out.println("0) Exit\n");
        System.out.println("Seciminizi edin: ");

        int choice = new InputChecker().choiceChecker(3);

        switch(choice){
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
            case 2 -> {}
            case 3 -> {
                user = new User();
                setNext(new LogInAndRegisterForm());
            }
        }
    }
}
