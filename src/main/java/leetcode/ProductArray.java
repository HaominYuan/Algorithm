package leetcode;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().multiply(new int[]{1, 2, 3, 4})));
    }

    static class Solution {
        int[] multiply(int[] a) {
            int[] b = new int[a.length];
            b[0] = 1;
            for (int i = 1; i < b.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }

            int temp = 1;
            for (int i = a.length - 2; i >= 0; i--) {
                temp = temp * a[i + 1];
                b[i] = b[i] * temp;
            }
            return b;
        }
    }

}
