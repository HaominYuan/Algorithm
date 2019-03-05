package leetcode;


public class K_thLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int start = 0, end = nums.length - 1, partition;
            k = nums.length - k;
            while ((partition = partition(nums, start, end)) != k) {
                if (k < partition) {
                    end = partition - 1;
                } else {
                    start = partition + 1;
                }
            }
            return nums[k];
        }

//        private int partition(int[] nums, int start, int end) {
//            int pivot = nums[end], index = start, tmp;
//            for (int i = start; i < end; i++) {
//                if (nums[i] < pivot) {
//                    tmp = nums[i];
//                    nums[i] = nums[index];
//                    nums[index] = tmp;
//                    index = index + 1;
//                }
//            }
//            nums[end] = nums[index];
//            nums[index] = pivot;
//            return index;
//        }

        private int partition(int[] nums, int left, int right){
            int mid = (left + right) / 2, pivot = nums[mid], lt = left;
            swap(nums, mid, right);
            for (int i = left; i < right; i++){
                if (pivot > nums[i]){
                    swap(nums, i, lt);
                    lt ++;
                }
            }
            swap(nums, lt, right);
            return lt;
        }

        private void swap(int[] nums, int num1, int num2) {
            int temp = nums[num1];
            nums[num1] = nums[num2];
            nums[num2] = temp;
        }

    }
}
