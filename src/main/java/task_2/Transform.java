package task_2;

import java.util.ArrayList;
import java.util.List;

public class Transform {

    static Integer transferDigitsByOneInNumber(int number) {

        List<Integer> integerList = new ArrayList<>();
        int newNum = 0;
        while (number > 0) {
            newNum = (number % 10) + 1;
            integerList.add((newNum));
            number /= 10;
        }

        StringBuilder nums = new StringBuilder();
        for (int i = integerList.size() - 1; i >= 0; i--) {
            nums.append(integerList.get(i));
        }

        return Integer.parseInt(nums.toString());
    }
}
