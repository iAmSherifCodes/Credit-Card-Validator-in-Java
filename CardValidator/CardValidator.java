package CardValidator;

public class CardValidator {

//    private OutputInterface outputInterface = new OutputInterface(cardTypeChecker(),getCardNumber(), getCardNumberLength(), getCardStatus());

    private final String cardNumber;

    public String cardStatus;

    public CardValidator(String cardNumber){
        this.cardNumber = cardNumber;
    }

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


    private String cardLengthValidity(){
        boolean isValid = false;
        isValid = cardNumber.length() >= 13 & cardNumber.length() <= 16;
        if (isValid)
            cardStatus = "Valid";
        else cardStatus = "Invalid";
        return cardStatus;
    }

    public String cardTypeChecker() {

        String cardType = "INVALID CARD TYPE";
        final int VISA = 4;
        final int MASTERCARD = 5;
        final int DISCOVER_CARD = 6;
        final int AMERICAN_EXPRESS = 37;

        switch (cardNumberList()[0]) {
            case VISA -> cardType = "VISA";
            case MASTERCARD -> cardType = "MASTERCARD";
            case DISCOVER_CARD -> cardType = "DISCOVER CARD";
        }

            int americanCardFirstDigit = AMERICAN_EXPRESS / 10;
            int americanCardSecondDigit = AMERICAN_EXPRESS % 10;
            boolean isAmericanExpressNumbers = cardNumberList()[0] == americanCardFirstDigit && cardNumberList()[1] == americanCardSecondDigit ;
            if (isAmericanExpressNumbers)
                cardType = "AMERICAN EXPRESS";

        return cardType;
    }

        public String sumOfCardNumbers() {
            //DOUBLING THE SECOND NUMBER FROM RIGHT TO LEFT

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

            int oddTotal = 0;
            for (int i = secondToTheLastNumberInTheList + 2; i > 0; i -= 2) {
                oddTotal += cardNumberList()[i - 1];
            }

            int cardNumbersSum = evenTotal + oddTotal;
            boolean cardStatusCheck = cardNumbersSum % 10 == 0;
            if (cardStatusCheck) cardStatus = "Valid";
            else cardStatus = "Invalid";

            return cardStatus;

        }
        public String validateCard () {
            cardNumberList();
            cardLengthValidity();
            cardTypeChecker();
            sumOfCardNumbers();
            return String.format("""
                    Credit Card Type: %s
                    Credit Card Number: %s
                    Credit Card Number Digit Length: %d
                    Credit Card Validility Status: %s
                    """, cardTypeChecker(), cardNumber, cardNumber.length(), cardStatus);
        }
}
