package handling;

import data.Vars;

/**
 * Created by Sphiinx on 4/13/2016.
 */
public class HandleSudoku {

    /**
     * Solves the given HandleSudoku in place.
     *
     * @param i     The vertical position to start.
     * @param j     The horizontal position to start.
     * @param cells The sudoku matrix.
     * @return The solved sudoku matrix.
     */
    public static boolean solve(int i, int j, int[][] cells) {
        if (i == 9) {
            i = 0;
            if (++j == 9) {
                return true;
            }
        }

        if (cells[i][j] != 0) {
            return solve(i + 1, j, cells);
        }

        for (int val = 1; val <= 9; ++val) {
            if (legal(i, j, val, cells)) {
                cells[i][j] = val;
                if (solve(i + 1, j, cells))
                    return true;
            }
        }

        cells[i][j] = 0;
        return false;
    }

    /**
     * Checks if the number is a legal number for that column, row, and grid.
     *
     * @param i     The vertical position.
     * @param j     The horizontal position.
     * @param val   The cells.
     * @param cells The sudoku matrix.
     * @return If the number is legal or not for that position.
     */
    public static boolean legal(int i, int j, int val, int[][] cells) {
        for (int k = 0; k < 9; ++k)
            if (val == cells[k][j]) {
                return false;
            }

        for (int k = 0; k < 9; ++k)
            if (val == cells[i][k]) {
                return false;
            }

        int boxRowOffset = (i / 3) * 3;
        int boxColOffset = (j / 3) * 3;
        for (int k = 0; k < 3; ++k) {
            for (int m = 0; m < 3; ++m) {
                if (val == cells[boxRowOffset + k][boxColOffset + m]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Prints the sudoku Matrix.
     *
     * @param cells The sudoku matrix.
     */
    public static void writeMatrix(int[][] cells) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0) {
                System.out.println(" -----------------------");
            }
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(cells[i][j] == 0 ? " " : Integer.toString(cells[i][j]));
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    /**
     * Resets the current matrix.
     */
    public static void resetMatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Vars.get().matrix[i][j] = 0;
            }
        }
    }

}

