package task_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailFenceCipherTest {

    @Test
    void checkFor3Rails() {
        String textForEncoding = "Serhii Dutchyn";
        String correctEncodingTest = "SiuyehiDthnr c";
        int railsNumber = 3;
        String encodedText = RailFenceCipher.encode(textForEncoding, railsNumber);
        String decodedText = RailFenceCipher.decode(encodedText, railsNumber);

        assertEquals(correctEncodingTest, encodedText);
        assertEquals(textForEncoding, decodedText);
    }

    @Test
    void expectedIllegalArgumentException() {
        String textForEncoding = "Serhii Dutchyn";
        assertThrows(IllegalArgumentException.class, () -> {
            RailFenceCipher.encode(textForEncoding, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RailFenceCipher.decode(textForEncoding, 0);
        });
    }

}