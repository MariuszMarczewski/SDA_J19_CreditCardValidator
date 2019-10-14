package pl.sda.pl.sda.checksums;

public class LuhnVerifier implements ChecksumVerifier {

    @Override
    public boolean verify(String cardNo) {
        
        int[] convertedCardNumber = convertStringToArray(cardNo);

        for (int i = convertedCardNumber.length - 2; i >= 0; i = i - 2) {
            int temp = convertedCardNumber[i] * 2;
            if (temp >= 10) {
                temp = temp - 9;
            }
            convertedCardNumber[i] = temp;
        }

        int sum = 0;
        for (int digit : convertedCardNumber) {
            sum += digit;
        }

        return sum % 10 == 0;
    }

    private int[] convertStringToArray(String cardNo) {
        int[] convertedCardNo = new int[cardNo.length()];
        int counter = 0;
        for (Character digit : cardNo.toCharArray()) {
            convertedCardNo[counter] = Character.getNumericValue(digit);
            counter++;
        }
        return convertedCardNo;
    }
}






