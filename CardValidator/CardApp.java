package CardValidator;

import java.util.Arrays;
import java.util.Scanner;

public class CardApp {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      System.out.print("Hello, Kindly Enter Card number to verify: ");
      String cardNumber = scan.nextLine();
              //"5399831619690403";

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
