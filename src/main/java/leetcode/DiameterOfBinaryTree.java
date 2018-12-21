package leetcode;


public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(treeNode1));
    }

    static class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            func(root);
            return max;
        }

        int func(TreeNode root) {
            if (root == null) {
                return -1;
            }

            int left = func(root.left);
            int right = func(root.right);
            max = Math.max(max, left + right + 2);
            return Math.max(left, right) + 1;
        }
    }
}
