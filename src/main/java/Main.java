import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, -1, -1, 0};
        System.out.println(new Solution().threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i - 1] != nums[i]) {
                    int left = i + 1, right = nums.length - 1, sum = -nums[i];
                    while (left < right) {
                        if (nums[left] + nums[right] == sum) {
                            lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left = left + 1;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right = right - 1;
                            }
                            left = left + 1;
                            right = right - 1;
                        } else if (nums[left] + nums[right] > sum) {
                            right = right - 1;
                        } else {
                            left = left + 1;
                        }
                    }
                }
            }
            return lists;
        }
    }



}