import CardDetails.CardForm;
import Flight.Flight;
import Flight.FlightManager;
import Flight.FlightService;
import LogInAndRegister.Login.LoginManager;
import LogInAndRegister.Login.LoginService;
import LogInAndRegister.Register.RegisterManager;
import LogInAndRegister.Register.RegisterService;
import TicketManager.TicketManager;
import User.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("----------------> Xos Gelmisiniz <---------------------\n");
        System.out.println("1)LogInAndRegister.Login \n");
        System.out.println("2)LogInAndRegister.Login.Register \n");
        RegisterService registerService = new RegisterManager(user);
//        registerService.register();
        LoginService loginService = new LoginManager();
//        loginService.login();
        Flight flight = new Flight();
        FlightService flightService = new FlightManager();
//        flightService.add(flight);
        //flightService.delete();
//        flightService.getAll();
//        flightService.update();
//        CardForm cardForm = new CardForm();
//        cardForm.process(user);

    }
}