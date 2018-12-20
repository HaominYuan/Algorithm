package leetcode;

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(new Solution().validMountainArray(new int[]{2, 1}));
        System.out.println(new Solution().validMountainArray(new int[]{3, 5, 5}));
        System.out.println(new Solution().validMountainArray(new int[]{0, 3, 2, 1}));
    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length <= 2) {
                return false;
            }
            int pivot = 0;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] == A[i + 1]) {
                    return false;
                }
                if (A[i] > A[i + 1]) {
                    pivot = i;
                    break;
                }
            }

            for (int i = A.length - 1; i > 0; i--) {
                if (A[i] == A[i - 1]) {
                    return false;
                }
                if (A[i - 1] < A[i]) {
                    return pivot == i;
                }
            }
            return false;
        }
    }

}
