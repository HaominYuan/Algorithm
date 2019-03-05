package leetcode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(20);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;



        System.out.println(new Solution().isValidBST(treeNode1));
    }

    static class Solution {
        double last = -Double.MAX_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (isValidBST(root.left)) {
                if (last < root.val) {
                    last = root.val;
                    return isValidBST(root.right);
                }
            }

            return false;
        }
    }
}
