package CardDetails;

public class Card {
    private String name;
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String securityCode;

    public Card(String name, String cardNumber, String expirationMonth, String expirationYear, String securityCode) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.securityCode = securityCode;
    }
}
