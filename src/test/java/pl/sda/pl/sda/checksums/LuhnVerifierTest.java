package pl.sda.pl.sda.checksums;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnVerifierTest {

    ChecksumVerifier verifier = new LuhnVerifier();

    @Test
    public void shouldReturnTrueFor9233() {
        //given
        final String number = "9233";

        //when
        boolean result = verifier.verify(number);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueFor74385() {
        //given
        final String number = "74385";

        //when
        boolean result = verifier.verify(number);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseFor74383() {
        //given
        final String number = "74383";

        //when
        int i = 0;
        boolean result = verifier.verify(number);

        //then
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueFor5501149031856642() {
        //given
        final String number = "5501149031856642";

        //when
        boolean result = verifier.verify(number);

        //then
        assertTrue(result);
    }
}

