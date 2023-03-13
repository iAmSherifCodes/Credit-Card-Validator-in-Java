package CardValidator;

public class CardValidator {
    private final String cardNumber;
    public String cardStatus;
    Output outputInterface ;
    private boolean isValid;
    String cardType = "INVALID CARD TYPE";

    public CardValidator(String cardNumber){
        this.cardNumber = cardNumber;
    }

    // COLLECTING THE CARD NUMBER AS A STRING AND CONVERTING IT TO AN ARRAY OF INTEGER OBJECT
    public int[] cardNumberList(){
        String[] numbersString = new String[cardNumber.length()];
        int[] numbersList = new int[numbersString.length];
        for (int i = 0 ; i < cardNumber.length(); i ++) charToList(numbersString, numbersList, i);
        return numbersList;
    }

    private void charToList(String[] numbersString, int[] numbersList, int i) {
        String s = String.valueOf(cardNumber.charAt(i));
        numbersString[i] = s;
        numbersList[i] = Integer.parseInt(numbersString[i]);
    }

    // DETERMINING CARD VALIDITY VIA IT'S LENGTH
    // card number length must be >= 13 and <= 16
    // 13 <= L <=16
    protected boolean cardLengthValidity(){
        isValid = cardNumber.length() >= 13 & cardNumber.length() <= 16;
        return isValid;
    }

    // DETERMINING CARD'S TYPE
    public String cardTypeChecker() {

        if (cardLengthValidity()){
            final int VISA = 4;
            final int MASTERCARD = 5;
            final int DISCOVER_CARD = 6;
            final int AMERICAN_EXPRESS = 37;

            // DETERMINING CARD TYPE THROUGH THE CARD'S FIRST NUMBER
            switch (cardNumberList()[0]) {
                case VISA -> cardType = "VISA";
                case MASTERCARD -> cardType = "MASTERCARD";
                case DISCOVER_CARD -> cardType = "DISCOVER CARD";
            }

            // DETERMINING AMERICAN EXPRESS CARD TYPE THROUGH THE CARD'S FIRST-TWO NUMBERS
            int americanCardFirstDigit = AMERICAN_EXPRESS / 10;
            int americanCardSecondDigit = AMERICAN_EXPRESS % 10;
            boolean isAmericanExpressNumbers = cardNumberList()[0] == americanCardFirstDigit && cardNumberList()[1] == americanCardSecondDigit ;
            if (isAmericanExpressNumbers) cardType = "AMERICAN EXPRESS";
        } else isValid =false;
        return cardType;
    }
        private boolean sumOfCardNumbers() {
            int secondToTheLastNumberInTheList = cardNumberList().length - 2;
            int evenTotal = 0;
            for (int i = secondToTheLastNumberInTheList; i >= 0 ; i -= 2) evenTotal = getEvenTotal(evenTotal, i);
            int oddTotal = 0;
            for (int i = secondToTheLastNumberInTheList + 2; i > 0; i -= 2) oddTotal += cardNumberList()[i - 1];
            return cardIsValid(evenTotal, oddTotal);
        }
    private boolean cardIsValid(int evenTotal, int oddTotal) {
        int cardNumbersSum = evenTotal + oddTotal;
        isValid = cardNumbersSum % 10 == 0;
        return isValid;
    }
    private int getEvenTotal(int evenTotal, int i) {
        int result = cardNumberList()[i] * 2;
        boolean isSingleDigit = result < 9;
        result = getResult(result, isSingleDigit);
        evenTotal += result;
        return evenTotal;
    }
    private static int getResult(int result, boolean isSingleDigit) {
        if (!isSingleDigit) {
            int firstDigit = result / 10;
            int secondDigit = result % 10;
            result = firstDigit + secondDigit;
        }
        return result;
    }
    private  String getCardNumber(){
        return this.cardNumber;
    }
    public String validateCard () {
        if ( cardLengthValidity() && sumOfCardNumbers()) cardStatus = "Valid"; else cardStatus = "Invalid";
        outputInterface = new Output(this.cardTypeChecker(), this.getCardNumber(), this.cardStatus);
        return outputInterface.toString();
    }

}
