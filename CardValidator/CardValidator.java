package CardValidator;

public class CardValidator {
    private final String cardNumber;
    public String cardStatus;
    OutputInterface outputInterface ;
    private boolean isValid;
    String cardType = "INVALID CARD TYPE";

    public CardValidator(String cardNumber){
        this.cardNumber = cardNumber;
    }

    // COLLECTING THE CARD NUMBER AS A STRING AND CONVERTING IT TO AN ARRAY OF INTEGER OBJECT
    public int[] cardNumberList(){
        String[] numbersString = new String[cardNumber.length()];
        int[] numbersList = new int[numbersString.length];
        for (int i = 0 ; i < cardNumber.length(); i ++){
            String s = String.valueOf(cardNumber.charAt(i));
            numbersString[i] = s;
            numbersList[i] = Integer.parseInt(numbersString[i]);
        }
        return numbersList;
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
            if (isAmericanExpressNumbers)
                cardType = "AMERICAN EXPRESS";
        } else isValid =false;


        return cardType;
    }

        public boolean sumOfCardNumbers() {
            //DOUBLING THE NUMBER IN EVEN INDEX FROM RIGHT TO LEFT

            int secondToTheLastNumberInTheList = cardNumberList().length - 2;
            int evenTotal = 0;
            for (int i = secondToTheLastNumberInTheList; i >= 0 ; i -= 2) {
                int result = cardNumberList()[i] * 2;
                boolean isSingleDigit = result < 9;
                if (!isSingleDigit) {
                    int firstDigit = result / 10;
                    int secondDigit = result % 10;
                    result = firstDigit + secondDigit;
                }
                evenTotal += result;
            }

            //ADDING THE NUMBERS IN ODD INDEX ONLY
            int oddTotal = 0;
            for (int i = secondToTheLastNumberInTheList + 2; i > 0; i -= 2) {
                oddTotal += cardNumberList()[i - 1];
            }

            // SUM TOTAL OF DOUBLED EVEN INDEX AND TOTAL OF ODD INDEX
            int cardNumbersSum = evenTotal + oddTotal;
            isValid = cardNumbersSum % 10 == 0;

            return isValid;

        }

    // QUERY METHOD FOR FINAL VARIABLE CARD NUMBER
    private  String getCardNumber(){
        return this.cardNumber;
    }

    public String validateCard () {
        if ( cardLengthValidity() && sumOfCardNumbers()) cardStatus = "Valid";
        else cardStatus = "Invalid";
        outputInterface = new OutputInterface(this.cardTypeChecker(), this.getCardNumber(), this.cardStatus);

        return outputInterface.toString();
    }

}
