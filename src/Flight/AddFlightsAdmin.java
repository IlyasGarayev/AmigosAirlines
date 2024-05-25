package Flight;

import ChainLogic.Chain;
import LogInAndRegister.LogInAndRegisterForm;
import SecurityCheck.InputChecker;
import User.User;

public class AddFlightsAdmin extends Chain {
    @Override
    public void process(User user) {
        FlightManager flightManager = new FlightManager();

        System.out.println("1) Ucus elave et\n2) Duzelis et\n3) Ucuslarin siyahisi\n4) Sil");
        System.out.println("5) Hesabdan cix\n0) Exit");

        int choice = new InputChecker().choiceChecker(5);
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
            case 1 -> {
                flightManager.add(new Flight());
                setNext(this);
            }
            case 2 -> {
                flightManager.update();
                setNext(this);
            }
            case 3 -> {
                flightManager.getAll();
                setNext(this);
            }
            case 4 -> {
                flightManager.delete();
                setNext(this);
            }
            case 5 -> {
                user = new User();
                setNext(new LogInAndRegisterForm());
            }
        }


    }
}
