package leetcode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new Solution().invertTree(treeNode1));
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            return root;
        }
    }
}
