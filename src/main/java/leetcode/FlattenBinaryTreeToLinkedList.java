package leetcode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode1.right = treeNode5;
        treeNode5.left = treeNode6;
        new Solution().flatten(treeNode1);
        System.out.println(treeNode1);
    }

    static class Solution {

        private TreeNode last = new TreeNode(0);

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            // 将上一个节点的右节点指向现在这个节点
            last.right = root;
            last.left = null;
            last = last.right;
            TreeNode temp = root.right;
            flatten(root.left);
            // 这个是右节点
            flatten(temp);
        }
    }
}
