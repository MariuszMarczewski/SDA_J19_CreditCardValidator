package pl.sda;


import pl.sda.issuers.IssuerDetector;
import pl.sda.pl.sda.checksums.ChecksumVerifier;
import pl.sda.pl.sda.checksums.LuhnVerifier;
import pl.sda.verifiers.CreditCardValidator;
import pl.sda.verifiers.ValidationResult;

public class App
{
    public static void main( String[] args ) {

        String cardNo = "5501149031856642";

        IssuerDetector detector = new IssuerDetector();
        ChecksumVerifier checksumVerifier = new LuhnVerifier();
        CreditCardValidator validator = new CreditCardValidator(checksumVerifier, detector);
        ValidationResult result = validator.validate(cardNo);

        System.out.println("Wynik walidacji numeru " + cardNo);
        System.out.println("Wystawca: " + result.getIssuerName());
        System.out.println("Cyfra kontrolna poprawna: " + result.isChecksumVerified());
    }
}