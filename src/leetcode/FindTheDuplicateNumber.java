package leetcode;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{2, 1, 3, 4, 2}));
    }

    static class MySolution {
        public int findDuplicate(int[] nums) {
            return find(nums, 1, nums.length - 1);
        }

        int find(int[] nums, int start, int end) {
            if (start == end) {
                return start;
            }

            int count = 0;
            int middle = (start + end) / 2;
            for (int num : nums) {
                if (start <= num && num <= middle) {
                    count = count + 1;
                }

            }
            if (count > (middle - start + 1)) {
                return find(nums, start, middle);
            }
            return find(nums, middle + 1, end);
        }
    }


    static class Solution {
        int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
    }
}

