package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode treeNode = Utils.constructTree(new int[]{5, 4, 8, 11, Integer.MAX_VALUE, 13, 4, 7, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1});
        System.out.println(new Solution().pathSum(treeNode, 22));

    }

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> lists = new ArrayList<>();
            func(lists, root, sum, new ArrayList<>());
            return lists;
        }

        private void func(List<List<Integer>> lists, TreeNode root, int sum, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (sum - root.val == 0 && root.right == null && root.left == null) {
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
            list.add(root.val);
            func(lists, root.left, sum - root.val, list);
            func(lists, root.right, sum - root.val, list);
            list.remove(list.size() - 1);
        }
    }
}
