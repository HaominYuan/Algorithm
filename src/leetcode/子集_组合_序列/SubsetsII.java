package leetcode.子集_组合_序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
//            排序是为了防止重复序列
            Arrays.sort(nums);
            func(lists, nums, new ArrayList<>(), 0);
            return lists;
        }

        void func(List<List<Integer>> lists, int[] nums, List<Integer> list, int index) {
//            这里不加入判断条件的原因是，当index>=nums.length的时候循环自动终止，相当于return
            lists.add(new ArrayList<>(list));


//            此层循环的意义相当于选还是不选。例如当i=2时，意味着1不选
            for (int i = index; i < nums.length; i++) {

//                一层中同样的元素只能出现一次，防止生成同样的子集
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }

                list.add(nums[i]);
                func(lists, nums, list, i + 1);
                list.remove(list.size() - 1);
            }


        }
    }
}
