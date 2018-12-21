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


    // 检查边界可以写在前面
    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (null == board || word == null || word.isEmpty() || board.length * board[0].length < word.length()) {
                return false;
            }

            boolean[][] isVisited = new boolean[board.length][board[0].length];
            char[] charArray = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, isVisited, charArray, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;

        }

        private boolean exist(char[][] board, boolean[][] isVisited, char[] charArray, int i, int j, int index) {
            if (index == charArray.length) {
                return true;
            }

            if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
                return false;
            }

            if (isVisited[i][j] || board[i][j] != charArray[index]) {
                return false;
            }

            isVisited[i][j] = true;

            boolean found = exist(board, isVisited, charArray, i + 1, j, ++index) ||
                    exist(board, isVisited, charArray, i - 1, j, index) ||
                    exist(board, isVisited, charArray, i, j + 1, index) ||
                    exist(board, isVisited, charArray, i, j - 1, index);
            if (!found) {
                isVisited[i][j] = false;
            }
            return found;

        }
    }
}
