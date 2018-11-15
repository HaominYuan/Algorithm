package leetcode;

public class ValidSudoku {
    public static void main(String[] args) {
        boolean[] flag = new boolean[2];

        char[][] board = new char[9][];

//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//
//        board[0] = new char[]{'5','3','.",".","7",".",".",".","."}


        System.out.println(flag[0]);
    }

    static class Solution {
        static boolean isValidSudoku(char[][] board) {
            boolean[][] grids = new boolean[9][];
            boolean[][] rows = new boolean[9][];
            boolean[][] columns = new boolean[9][];
            for (int i = 0; i < grids.length; i++) {
                grids[i] = new boolean[9];
                rows[i] = new boolean[9];
                columns[i] = new boolean[9];
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    board[i][j] = (char) (board[i][j] - 49);
                    if (!rows[i][board[i][j]]) {
                        rows[i][board[i][j]] = true;
                    } else {
                        return false;
                    }

                    if (!columns[j][board[i][j]]) {
                        columns[j][board[i][j]] = true;
                    } else {
                        return false;
                    }

                    if (!grids[i / 3 * 3 + j / 3][board[i][j]]) {
                        grids[i / 3 * 3 + j / 3][board[i][j]] = true;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
