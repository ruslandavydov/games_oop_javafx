package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1) {
                if (monoHorizontal(board, index) || monoVertical(board, index)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][]board, int row) {
        boolean rsl = true;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[row][cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean monoVertical(int[][]board, int cell) {
        boolean rsl = true;
        for (int[] row : board) {
            if (row[cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
