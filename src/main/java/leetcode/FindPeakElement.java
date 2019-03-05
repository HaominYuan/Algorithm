package leetcode;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(new MySolution().findPeakElement(new int[]{1, 2, 3, 1}));
    }

    static class MySolution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }

            if (nums[0] > nums[1]) {
                return 0;
            }

            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }

            for (int i = 1; i < nums.length - 1; i++) {
                if (2 * nums[i] > nums[i - 1] + nums[i + 1]) {
                    return i;
                }
            }

            return -1;
        }
    }


    static class Solution {
        public int findPeakElement(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    low = mid + 1;  //注意为什么要+1，因为mid位置一定不是峰，而low=mid+1有可能是峰}
                } else {
                    high = mid;      //注意这里为什么不加+，因为high=mid有可能是峰}
                }
            }
            return low;
        }
    }
}

