package task_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    @Test
    void checkIfCorrectIncreased() {

        int number = 109001;
        int correctTransformation = 2110112;

        assertEquals(correctTransformation, Transform.transferDigitsByOneInNumber(number));
    }

}