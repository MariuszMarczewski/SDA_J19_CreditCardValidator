package pl.sda.pl.sda.checksums;

public class LuhnArrayVerifier implements ChecksumVerifier {

    @Override
    public boolean verify(String cardNo) {
        char[] chars = cardNo.toCharArray();
        int counter = 1;
        long sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer increment = Character.getNumericValue(chars[i]);
            increment = counter % 2 == 0 ? increment * 2 : increment;
            increment = increment >= 10 ? increment - 9 : increment;
            sum += increment;
            counter++;
        }
        return sum % 10 == 0;
    }
}

