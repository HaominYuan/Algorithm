package leetcode;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MySolution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class MySolution {
        public int[] twoSum(int[] numbers, int target) {
            int[] index = new int[]{0, numbers.length - 1};
            while (true) {
                int tmp = numbers[index[0]] + numbers[index[1]];
                if (tmp == target) {
                    index[0] = index[0] + 1;
                    index[1] = index[1] + 1;
                    return index;
                } else if (tmp > target) {
                    index[1] = index[1] - 1;
                } else {
                    index[0] = index[0] + 1;
                }
            }
        }
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int p1 = 0, p2 = numbers.length - 1;
            int[] result = new int[2];
            while (p1 < p2) {
                while (numbers[p1] + numbers[p2] > target) p2--;
                if (numbers[p1] + numbers[p2] == target) {
                    result[0] = p1 + 1;
                    result[1] = p2 + 1;
                    return result;
                }
                while (numbers[p1] + numbers[p2] < target) p1++;
            }
            return result;
        }
    }
}
