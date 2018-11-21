public class Tmp {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int nCurSum = 0;
            int nGreatestSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nCurSum <= 0) {
                    nCurSum = nums[i];
                } else {
                    nCurSum += nums[i];
                }
                nGreatestSum = Math.max(nCurSum, nGreatestSum);
            }
            return nGreatestSum;
        }
    }
}
