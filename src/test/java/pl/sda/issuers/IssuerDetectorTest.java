package pl.sda.issuers;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssuerDetectorTest {

    private IssuerDetector detector = new IssuerDetector();

    @Test
    public void shouldReturnVisaForPrefix4AndLength16() {
        //given
        final String cardNo = "4000000000000000";
        final String expectedResult = "visa";

        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnMasterCardForPrefixAndLength16() {
        //given
        final String cardNo = "5100000000000000";
        final String expectedResult = "mastercard";

        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnAmericanExpressForPrefix34AndLength15() {
        //given
        final String cardNo = "340000000000000";
        final String expectedResult = "americanexpress";

        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals(expectedResult, result.toLowerCase());
    }

    @Test
    public void shouldReturnUnknownForPrefix0() {
        //given
        final String cardNo = "0000000000000000";
        final String expectedResult = "unknown";

        //when
        String result = detector.detect(cardNo);

        //then
        assertEquals(expectedResult, result.toLowerCase());
    }
}