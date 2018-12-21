package leetcode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
//                3
//               / \
//              9  20
//                /  \
//               15   7
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(new Solution().isBalanced(treeNode1));
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return func(root) != -1;
        }

        int func(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = func(root.left);
            if (left == -1) {
                return -1;
            }
            int right = func(root.right);
            if (right == -1) {
                return -1;
            }

            if (Math.abs(left - right) > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }
}
