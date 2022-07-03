package task_1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RailFenceCipher {

    public static String encode(String encodeRow, int railsNumber) {
        if (railsNumber < 2)
            throw new IllegalArgumentException("Rails number must be more than 1");

        int numberOfCol = encodeRow.length();
        Character[][] encodeMatrix = new Character[railsNumber][numberOfCol];
        boolean down = true;
        int rowCharIndex = 0;

        for (int i = 0; i < numberOfCol; ) {
            if (down) {
                for (int j = 0; j < railsNumber && rowCharIndex < numberOfCol; j++) {
                    encodeMatrix[j][i] = encodeRow.charAt(rowCharIndex);
                    rowCharIndex++;
                    i++;
                }
                down = false;
            } else {
                for (int j = railsNumber - 2; j > 0 && rowCharIndex < numberOfCol; j--) {
                    encodeMatrix[j][i] = encodeRow.charAt(rowCharIndex);
                    rowCharIndex++;
                    i++;
                }
                down = true;
            }
        }

        StringBuilder encodedString = new StringBuilder();
        for (Character[] row : encodeMatrix) {
            List<Character> encodedRow = Arrays.stream(row)
                    .filter(Objects::nonNull)
                    .toList();

            encodedString.append(encodedRow.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
        }
        return encodedString.toString();
    }

    public static String decode(String decodeString, int railsNumber) {
        if (railsNumber < 2)
            throw new IllegalArgumentException("Rails number must be more than 1");


        char[] decrypted = new char[decodeString.length()];
        int n = 0;
        for (int k = 0; k < railsNumber; k++) {
            int index = k;
            boolean down = true;
            while (index < decodeString.length()) {
                decrypted[index] = decodeString.charAt(n++);

                if (k == 0 || k == railsNumber - 1) {
                    index = index + 2 * (railsNumber - 1);
                } else if (down) {
                    index = index + 2 * (railsNumber - k - 1);
                    down = false;
                } else {
                    index = index + 2 * k;
                    down = true;
                }
            }
        }
        return new String(decrypted);
    }
}
