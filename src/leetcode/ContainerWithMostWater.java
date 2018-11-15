package leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(Solution.maxArea(array));
    }


    static class Solution {
        static int maxArea(int[] height) {
            int i = 0, j = height.length - 1;
            int max = Integer.MIN_VALUE;
            int temp = 0;
            int min;
            while (i < j) {
                min = height[i] < height[j] ? height[i] : height[j];
                temp = (j - i) * min;
                max = max > temp ? max : temp;
                if (min == height[i]) {
                    i++;
                } else {
                    j--;
                }
            }
            return max;
        }

    }
}
