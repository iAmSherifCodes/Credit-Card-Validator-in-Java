package CardValidator;

public class OutputInterface {
    private final String cardType;
    private final String cardNumber;
    private final int cardLength;
    private final String cardStatus;

    private String getCardType() {
        return cardType;
    }

    private String getCardNumber() {
        return cardNumber;
    }

    private int getCardLength() {
        return cardLength;
    }

    private String getCardStatus() {
        return cardStatus;
    }

    public OutputInterface(String cardType, String cardNumber, int cardLength, String cardStatus ){
        this.cardLength = cardLength;
        this.cardNumber = cardNumber;
        this.cardStatus = cardStatus;
        this.cardType = cardType;
    }

    public String toString(){
        return String.format("""
                Credit Card Type: %s
                Credit Card Number: %s
                Credit Card Number Digit Length: %s
                Credit Card Validility Status: %s
                """ , getCardType() , getCardNumber(), getCardLength(),getCardStatus());
    }
}
