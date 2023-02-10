package CardValidator;

public class CardApp {
    public static void main(String[] args) {
        String cardNumber = "5399834414947010";
        CardValidator cardValidator = new CardValidator(cardNumber);

        System.out.println(cardValidator.validateCard());
    }
}
