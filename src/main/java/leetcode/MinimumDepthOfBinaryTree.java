package leetcode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
        System.out.println(new Solution().minDepth(treeNode1));
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
