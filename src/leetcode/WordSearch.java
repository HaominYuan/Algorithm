package leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = new char[3][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new char[4];
        }
        matrix[0][0] = 'A';
        matrix[0][1] = 'B';
        matrix[0][2] = 'C';
        matrix[0][3] = 'E';
        matrix[1][0] = 'S';
        matrix[1][1] = 'F';
        matrix[1][2] = 'E';
        matrix[1][3] = 'S';
        matrix[2][0] = 'A';
        matrix[2][1] = 'D';
        matrix[2][2] = 'E';
        matrix[2][3] = 'E';

        System.out.println(new Solution().exist(matrix, "ABCESEEEFS"));
    }

    static class MySolution {
        public boolean exist(char[][] board, String word) {
            if ("".equals(word)) {
                return false;
            }

            int sum = board.length * board[0].length;

            if (word.length() > sum) {
                return false;
            }
            boolean[][] marked = new boolean[board.length][];
            for (int i = 0; i < marked.length; i++) {
                marked[i] = new boolean[board[i].length];
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (func(board, i, j, word, 0, marked)) {
                        return true;
                    }
                }
            }
            return false;
        }


        boolean func(char[][] board, int x, int y, String word, int index, boolean[][] marked) {
            if (index == word.length() - 1 && board[x][y] == word.charAt(index)) {
                return true;
            }
            if (board[x][y] != word.charAt(index)) {
                return false;
            }


            marked[x][y] = true;
            if (index + 1 < word.length()) {
                if (x + 1 < board.length && !marked[x + 1][y]) {
                    if (func(board, x + 1, y, word, index + 1, marked)) {
                        marked[x][y] = false;
                        return true;
                    }
                }

                if (x - 1 >= 0 && !marked[x - 1][y]) {
                    if (func(board, x - 1, y, word, index + 1, marked)) {
                        marked[x][y] = false;
                        return true;
                    }
                }
                if (y + 1 < board[x].length && !marked[x][y + 1]) {
                    if (func(board, x, y + 1, word, index + 1, marked)) {
                        marked[x][y] = false;
                        return true;
                    }
                }
                if (y - 1 >= 0 && !marked[x][y - 1]) {
                    if (func(board, x, y - 1, word, index + 1, marked)) {
                        marked[x][y] = false;
                        return true;
                    }
                }
            }
            marked[x][y] = false;
            return false;
        }
    }


    static class Solution {
        int m;
        int n;

        public boolean exist(char[][] board, String word) {
            if (null == board || word == null || word.isEmpty()) {
                return false;
            }

            boolean[][] used = new boolean[board.length][board[0].length];


            m = board.length;
            n = board[0].length;

            char[] charArray = word.toCharArray();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (exist(board, used, charArray, i, j, 0)) {
                        return true;
                    }
                }
            }

            return false;

        }

        private boolean exist(char[][] board, boolean[][] mem, char[] charArray, int i, int j, int index) {
            if (index == charArray.length) {
                return true;
            }

            if (i >= m || i < 0) {
                return false;
            }

            if (j >= n || j < 0) {
                return false;
            }


            if (mem[i][j] || board[i][j] != charArray[index]) {
                return false;
            }

            mem[i][j] = true;
            // up -> right -> down -> left
            boolean found = exist(board, mem, charArray, i - 1, j, index + 1)
                    || exist(board, mem, charArray, i, j + 1, index + 1)
                    || exist(board, mem, charArray, i + 1, j, index + 1)
                    || exist(board, mem, charArray, i, j - 1, index + 1);


            // recover
            if (!found) mem[i][j] = false;


            return found;
        }
    }
}
