package CardValidator;

import javax.swing.*;

public class CardApp {
    public static void main(String[] args) {

      String cardNumber = input("Hello, Kindly Enter Card number to verify: ");
              //"5399831619690403";

                     // TEST EXAMPLES
//        String cardNumber = "45678789264536321212";
//        String cardNumber ="3756787892645368";
//        String cardNumber = "6756787892645368";
//        String cardNumber = "456787821212";
        CardValidator cardValidator = new CardValidator(cardNumber);
        print(cardValidator.validateCard());
    }
    private static void print(String message){
        JOptionPane.showMessageDialog(null, message);
        System.exit(12);
    }
    private static String input(Object message){
        return JOptionPane.showInputDialog(message);
    }
}
