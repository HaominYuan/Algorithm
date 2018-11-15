package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrayII {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                } else if (nums1[i] < nums2[j]) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
            }
            int[] nums = new int[list.size()];
            for (i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
            return nums;
        }
    }
}
