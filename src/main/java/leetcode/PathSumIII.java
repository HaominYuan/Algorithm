package leetcode;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = Utils.constructTree(new int[]{
                10, 5, -3, 3, 2, Integer.MAX_VALUE, 11, 3, -2, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, Integer.MAX_VALUE
        });
        System.out.println(new Solution().pathSum(root, 8));

    }

    static class Solution {
        public int pathSum(TreeNode root, int sum) {
            return 1;
        }
    }
}
