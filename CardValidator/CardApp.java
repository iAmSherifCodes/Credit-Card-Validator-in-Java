package CardValidator;

import java.util.Arrays;

public class CardApp {
    public static void main(String[] args) {

      String cardNumber = "5399831619690403";

                     // TEST CASES
//        String cardNumber = "45678789264536321212";
//        String cardNumber ="3756787892645368";
//        String cardNumber = "6756787892645368";
//        String cardNumber = "6756787892645368";
//        String cardNumber = "456787821212";
        CardValidator cardValidator = new CardValidator(cardNumber);
        System.out.println(cardValidator.validateCard());
    }
}
