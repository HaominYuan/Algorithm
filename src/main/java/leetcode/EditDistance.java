package leetcode;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("distance", "springbok"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {


            if (word1.length() == 0) {
                return word2.length();
            }

            if (word2.length() == 0) {
                return word1.length();
            }


            int[][] state = new int[word1.length() + 1][];
            for (int i = 0; i < state.length; i++) {
                state[i] = new int[word2.length() + 1];
            }


            for (int i = 0; i < word1.length() + 1; i++) {
                state[i][0] = i;
            }

            for (int j = 1; j < word2.length() + 1; j++) {
                state[0][j] = j;
            }


            for (int i = 1; i < word1.length() + 1; i++) {
                for (int j = 1; j < word2.length() + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        state[i][j] = state[i - 1][j - 1];
                    } else {
                        state[i][j] = state[i - 1][j - 1] + 1;
                    }
                    state[i][j] = Math.min(state[i][j], state[i - 1][j] + 1);
                    state[i][j] = Math.min(state[i][j], state[i][j - 1] + 1);
                }
            }

            for (int i1 = 0; i1 < state.length; i1++) {
                int[] aD = state[i1];
                for (int i = 0; i < aD.length; i++) {
                    int anAD = aD[i];
                    System.out.print(anAD + "\t");
                }
                System.out.println();
            }



            return state[word1.length()][word2.length()];
        }
    }
}
