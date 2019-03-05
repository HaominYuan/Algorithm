package leetcode;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{1, 2, 1, 1, 1}));
    }
    static class Solution {
        int minStep = Integer.MAX_VALUE;

        public int jump(int[] nums) {
            return greedy(nums);
        }

        void backtrackingSearch(int[] nums, int index, int step) {
            if (index == nums.length - 1 && step < minStep) {
                minStep = step;
                return;
            }

            if (step + 1 >= minStep) {
                return;
            }


            for (int i = 1; i <= nums[index]; i++) {
                backtrackingSearch(nums, index + i, step + 1);
            }
        }


        int dynamicProgramming(int[] nums) {
            int[] state = new int[nums.length];
            state[nums.length - 1] = 0;
            for (int i = state.length - 2; i >= 0; i--) {
                if (nums[i] + i >= nums.length - 1) {
                    state[i] = 1;
                } else {
                    int minStep = Integer.MAX_VALUE;
                    for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
                        if (state[i + j] != Integer.MAX_VALUE && state[i + j] + 1 < minStep) {
                            minStep = state[i + j] + 1;
                        }
                    }
                    state[i] = minStep;
                }
            }
            return state[0];
        }


        int greedy(int[] nums) {
            int begin = 0, end = 0, step = 0, farthest;
            while (end < nums.length - 1) {
                farthest = end;
                for (int i = begin; i <= end; i++) {
                    farthest = Math.max(farthest, i + nums[i]);
                }
                begin = end + 1;
                end = farthest;
                step = step + 1;
            }
            return step;
        }
    }
}
