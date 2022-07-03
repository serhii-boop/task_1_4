package task_3;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    static boolean validate(List<List<Integer>> sudokuMatrix) {
        return checkDataStructure(sudokuMatrix) && checkSmallSquares(sudokuMatrix) && checkRowAndCol(sudokuMatrix);
    }

    private static boolean checkRowAndCol(List<List<Integer>> sudokuMatrix) {
        for (List<Integer> row : sudokuMatrix) {
            if (row.stream().distinct().count() != sudokuMatrix.size()) {
                return false;
            }
        }

        for (int i = 0; i < sudokuMatrix.size(); i++) {
            List<Integer> integerList = new ArrayList<>();
            for (List<Integer> matrix : sudokuMatrix) {
                integerList.add(matrix.get(i));
            }
            if (integerList.stream().distinct().count() != integerList.size())
                return false;
        }
        return true;
    }

    private static boolean checkSmallSquares(List<List<Integer>> sudokuMatrix) {
        int elementsOfRowInSmallSquare = (int) Math.sqrt(sudokuMatrix.size());
        int startRowIndex = 0;
        int startColIndex = 0;
        int currentRowSquare = elementsOfRowInSmallSquare;

        for (int i = startRowIndex; i < sudokuMatrix.size(); i += elementsOfRowInSmallSquare) {
            for (int j = startColIndex; j < sudokuMatrix.size(); j += elementsOfRowInSmallSquare) {

                List<Integer> smallSquare = new ArrayList<>();
                for (int k = startRowIndex; k < currentRowSquare; k++) {
                    for (int n = startColIndex; n < elementsOfRowInSmallSquare + startColIndex; n++) {
                        smallSquare.add(sudokuMatrix.get(k).get(n));
                    }
                }
                if (smallSquare.stream().distinct().count() != sudokuMatrix.size()) {
                    return false;
                } else {
                    startColIndex += elementsOfRowInSmallSquare;
                }

            }
            startColIndex = 0;
            currentRowSquare += elementsOfRowInSmallSquare;
            startRowIndex += elementsOfRowInSmallSquare;
        }

        return true;
    }

    private static boolean checkDataStructure(List<List<Integer>> sudokuMatrix) {
        if (Math.sqrt(sudokuMatrix.size()) % 1 != 0 || sudokuMatrix.size() <= 1) {
            return false;
        }

        for (List<Integer> row : sudokuMatrix) {
            if (Math.sqrt(row.size()) % 1 != 0 || row.size() != sudokuMatrix.size()) {
                return false;
            }
        }

        return true;
    }

}
