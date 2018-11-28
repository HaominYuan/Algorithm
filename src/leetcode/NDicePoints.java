package leetcode;

public class NDicePoints {
    public static void main(String[] args) {
        new Solution().cal(3);
    }

    static class Solution {
        public void cal(int n) {
            double[] state = new double[6 * n];
            double[] last = new double[6 * n];
            for (int i = 0; i < 6; i++) {
                state[i] = 1;
            }

            for (int i = 1; i < n; i++) {
                System.arraycopy(state, 0, last, 0, last.length);

                for (int j = i; j < state.length; j++) {
                    state[j] = 0;
                    for (int k = 1; k <= 6; k++) {
                        if (j - k >= i - 1) {
                            state[j] = state[j] + last[j - k];
                        } else {
                            break;
                        }
                    }
                }
            }

            for (int i = n - 1; i < 6 * n; i++) {
                System.out.println(i + 1 + ":" + state[i]);
            }
        }
    }

}
