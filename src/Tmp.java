import java.util.Arrays;

public class Tmp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_R().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
    }

    static class NaiveSolution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid = (left + right) / 2;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == target) {
                    break;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else if (nums[left] == target) {
                    mid = left;
                    break;
                } else {
                    mid = right;
                    break;
                }
            }
            if (left > right) {
                return new int[]{-1, -1};
            }


            int[] range = new int[2];
            range[0] = range[1] = mid;
            while (range[0] - 1 >= left && nums[range[0] - 1] == target) {
                range[0] = range[0] - 1;
            }

            while (range[1] + 1 <= right && nums[range[1] + 1] == target) {
                range[1] = range[1] + 1;
            }
            return range;
        }
    }

    static class Solution_R {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int[] range = new int[2];
            range[0] = nums.length;
            range[1] = -1;
            search(nums, 0, nums.length - 1, target, range);
            if (range[0] == nums.length) {
                range[0] = -1;
            }
            return range;
        }

        void search(int[] nums, int left, int right, int target, int[] range) {
            if (left > right || nums[right] < target || target < nums[left]) {
                return;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (nums[left] != target) {
                    search(nums, left, mid - 1, target, range);
                } else {
                    range[0] = Math.min(range[0], left);
                    range[1] = Math.max(range[1], left);
                }

                if (nums[right] != target) {
                    search(nums, mid + 1, right, target, range);
                } else {
                    range[0] = Math.min(range[0], right);
                    range[1] = Math.max(range[1], right);
                }
                range[0] = Math.min(range[0], mid);
                range[1] = Math.max(range[1], mid);

            } else if (target < nums[mid]) {
                search(nums, left, mid - 1, target, range);
            } else {
                search(nums, mid + 1, right, target, range);
            }


        }
    }
}
