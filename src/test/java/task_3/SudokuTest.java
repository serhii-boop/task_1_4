package task_3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    static List<List<Integer>> correctSudokuMatrix = List.of(
            List.of(7, 8, 4, 1, 5, 9, 3, 2, 6),
            List.of(5, 3, 9, 6, 7, 2, 8, 4, 1),
            List.of(6, 1, 2, 4, 3, 8, 7, 5, 9),

            List.of(9, 2, 8, 7, 1, 5, 4, 6, 3),
            List.of(3, 5, 7, 8, 4, 6, 1, 9, 2),
            List.of(4, 6, 1, 9, 2, 3, 5, 8, 7),

            List.of(8, 7, 6, 3, 9, 4, 2, 1, 5),
            List.of(2, 4, 3, 5, 6, 1, 9, 7, 8),
            List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));

    static List<List<Integer>> sudokuIncorrectSize = List.of(

            List.of(5, 3, 9, 6, 7, 2, 8, 4, 1),
            List.of(6, 1, 2, 4, 3, 8, 7, 5, 9),

            List.of(9, 2, 8, 7, 1, 5, 4, 6, 3),
            List.of(3, 5, 7, 8, 4, 6, 1, 9, 2),
            List.of(4, 6, 1, 9, 2, 3, 5, 8, 7),

            List.of(8, 7, 6, 3, 9, 4, 2, 1, 5),
            List.of(2, 4, 3, 5, 6, 1, 9, 7, 8),
            List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));

    // Incorrect first square
    static List<List<Integer>> sudokuIncorrectSmallSquare = List.of(
            List.of(1, 8, 4, 1, 5, 9, 3, 2, 6),
            List.of(5, 3, 9, 6, 7, 2, 8, 4, 1),
            List.of(6, 1, 2, 4, 3, 8, 7, 5, 9),

            List.of(9, 2, 8, 7, 1, 5, 4, 6, 3),
            List.of(3, 5, 7, 8, 4, 6, 1, 9, 2),
            List.of(4, 6, 1, 9, 2, 3, 5, 8, 7),

            List.of(8, 7, 6, 3, 9, 4, 2, 1, 5),
            List.of(2, 4, 3, 5, 6, 1, 9, 7, 8),
            List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));

    @Test
    void validateCorrectSudoku() {
        assertTrue(Sudoku.validate(correctSudokuMatrix));
    }

    @Test
    void validateSudokuWithWrongSize() {
        assertFalse(Sudoku.validate(sudokuIncorrectSize));
    }

    @Test
    void validateSudokuWithWrongSguare() {
        assertFalse(Sudoku.validate(sudokuIncorrectSmallSquare));
    }

}