package leetcode;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[9][];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(Solution.solveSudoku(board));
    }

    static class Solution {
        static  boolean solveSudoku(char[][] board) {
            if (isValidSudoku(board)) {
                return solve(board);
            }
            return false;
        }

        static void display(char[][] board) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char[] aBoard : board) {
                for (char anABoard : aBoard) {
                    stringBuilder.append(anABoard).append(" ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
        }

        static  boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        for (int k = 0; k < 9; k++) {
                            board[i][j] = (char) ('1' + k);
                            if (isOK(board, i, j)) {
                                if (solve(board)) {
                                    return true;
                                }
                            }
                            board[i][j] = '.';
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        static boolean isOK(char[][] board, int x, int y) {
            for (int i = 0; i < board[y].length; i++) {
                if (i != x && board[i][y] == board[x][y]) {
                    return false;
                }
            }

            for (int j = 0; j < board.length; j++) {
                if (j != y && board[x][j] == board[x][y]) {
                    return false;
                }
            }

            for (int i = x / 3 * 3; i < (x / 3 + 1) * 3; i++) {
                for (int j = y / 3 * 3; j < (y / 3 + 1) * 3; j++) {
                    if ((i != x || j != y) && board[i][j] == board[x][y]) {
                        return false;
                    }
                }
            }
            return true;
        }


        static boolean isValidSudoku(char[][] board) {
            boolean[][] grids = new boolean[9][];
            boolean[][] rows = new boolean[9][];
            boolean[][] columns = new boolean[9][];
            for (int i = 0; i < grids.length; i++) {
                grids[i] = new boolean[9];
                rows[i] = new boolean[9];
                columns[i] = new boolean[9];
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int index = board[i][j] - '1';
                    if (!rows[i][index]) {
                        rows[i][index] = true;
                    } else {
                        return false;
                    }

                    if (!columns[j][index]) {
                        columns[j][index] = true;
                    } else {
                        return false;
                    }

                    if (!grids[i / 3 * 3 + j / 3][index]) {
                        grids[i / 3 * 3 + j / 3][index] = true;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }

        static boolean isWin(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
