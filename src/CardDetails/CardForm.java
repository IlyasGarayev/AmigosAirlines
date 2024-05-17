package CardDetails;

import ChainLogic.Chain;
import Flight.Flight;
import TicketManager.TicketManager;
import User.User;
import TicketManager.Ticket;

import java.util.*;

public class CardForm extends Chain {
    @Override
    public void process(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kartin uzerinde qeyd olunan ad:");
        String name = scanner.nextLine();
        System.out.println("Kart nomrenizi daxil edin:");
        String cardNumber = scanner.nextLine();
        while (cardNumber.length()!=16){
            System.out.println("Kart nomresi 16 reqemli olmalidir, zehmet olmasa duzgun formada qeyd edin:");
            cardNumber = scanner.nextLine();
        }
        System.out.println("Kartin son istifade tarixini qeyd edin:");
        System.out.println("Ay:");
        String expirationMonth = scanner.nextLine();
        System.out.println("Il:");
        String expirationYear = scanner.nextLine();
        System.out.println("Tehlukesizlik kodu:");
        String securityCode = scanner.nextLine();
        while ( securityCode.length()!=3){
            System.out.println("Tehlukesizlik kodu 3 reqemli olmalidir, zehmet olmasa duzgun formada qeyd edin:");
            securityCode = scanner.nextLine();
        }

        Card card = new Card(name,cardNumber,expirationMonth,expirationYear,securityCode);
        System.out.println("Kart melumatlari yoxlanilir...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Melumatlar tesdiqlendi!");
        Ticket ticket = new Ticket(
                String.valueOf(new Random().nextInt(100+1)),
                user.getName() + " " + user.getLastname(),
                user.getDesiredFlight().getOriginAndDestination(),
                user.getDesiredFlight().getFlightTime()


        );
        for (Map.Entry<Flight, List<Ticket>> me :
                TicketManager.allTickets.entrySet()) {

            if (me.getKey().getFlightNumber().equals(user.getDesiredFlight().getFlightNumber())){
                me.getValue().add(ticket);
                break;
            }

        }




    }
}
