package leetcode;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
//        -10,9,20,null,null,15,7
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(-1);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
        System.out.println(new Solution().maxPathSum(treeNode1));
    }

    static class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            func(root);
            return max;
        }

        int func(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(func(root.left), 0);
            int right = Math.max(func(root.right), 0);
            max = Math.max(max, left + right + root.val);
            return Math.max(left, right) + root.val;
        }

    }
}
