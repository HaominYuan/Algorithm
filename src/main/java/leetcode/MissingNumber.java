package leetcode;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MySolution().missingNumber(new int[]{3, 0, 1}));
    }

    static class MySolution {
        public int missingNumber(int[] nums) {
            int x = nums.length;
            for (int i = 0; i < nums.length; i++) {
                x = x ^ i;
                x = x ^ nums[i];
            }
            return x;
        }
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for(int i :nums)
                sum+=i;
            return (((int)Math.pow(n,2)+n)-2*sum)/2;
        }
    }


}
