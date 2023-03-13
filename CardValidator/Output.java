package CardValidator;

public class Output {
    private final String cardType;
    private final String cardNumber;
    private final String cardStatus;

    public Output(String cardType, String cardNumber, String cardStatus ){
        this.cardNumber = cardNumber;
        this.cardStatus = cardStatus;
        this.cardType = cardType;
    }

    public int getCardNumberLength() {
        return cardNumber.length();
    }

    public String toString(){
        return String.format("""
                Credit Card Type: %s
                Credit Card Number: %s
                Credit Card Number Digit Length: %s
                Credit Card Validity Status: %s
                """ , this.cardType , this.cardNumber, getCardNumberLength(),this.cardStatus);
    }


}
