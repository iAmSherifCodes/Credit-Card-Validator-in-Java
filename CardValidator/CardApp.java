package CardValidator;

import java.util.Arrays;

public class CardApp {
    public static void main(String[] args) {
        String cardNumber = "371234547895004";
        CardValidator cardValidator = new CardValidator(cardNumber);
        System.out.println(cardValidator.validateCard());
    }
}
