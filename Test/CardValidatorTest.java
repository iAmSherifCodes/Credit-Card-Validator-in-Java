import CardValidator.CardValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardValidatorTest {
//    String cardNumber = "5399831619690403";
 //   String cardNumber; //= "45678789264536321212";
    CardValidator validator;
//    @BeforeEach
//    void setUp(){
////         validator = new CardValidator(cardNumber);
//    }
    @Test
    void testThatTheCardLengthIsValid(){
        String cardNumber = "45678789264536321212";
        validator = new CardValidator(cardNumber);
        int[] list = {4,5,6,7,8,7,8,9,2,6,4,5,3,6,3,2,1,2,1,2};
        assertEquals(Arrays.toString(list), Arrays.toString(validator.cardNumberList()));
    }

    @Test
    void testForTheCardTypeIsAmericanExpress(){
      String  cardNumber = "3756787892645368";
        validator = new CardValidator(cardNumber);
        assertEquals("AMERICAN EXPRESS", validator.cardTypeChecker());
    }

    @Test
    void testForTheCardTypeIsVisa(){
        String cardNumber = "4756787892645368";
        validator = new CardValidator(cardNumber);
        assertEquals("VISA", validator.cardTypeChecker());
    }

    @Test
    void testForTheCardTypeIsMasterCard(){
        String cardNumber = "5756787892645368";
        validator = new CardValidator(cardNumber);
        assertEquals("MASTERCARD", validator.cardTypeChecker());
    }

    @Test
    void testForTheCardTypeIsDiscoverCard(){
      String  cardNumber = "6756787892645368";
        validator = new CardValidator(cardNumber);
        assertEquals("DISCOVER CARD", validator.cardTypeChecker());
    }

    @Test
    void cardValidityThroughTheCardNumber(){
        String  cardNumber = "6756787892645368";
        validator = new CardValidator(cardNumber);
        validator.sumOfCardNumbers();
        String status = validator.cardStatus;
        assertEquals("Invalid", status);
    }
}
