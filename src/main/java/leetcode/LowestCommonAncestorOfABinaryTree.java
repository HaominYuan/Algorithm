package leetcode;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(4);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;
        System.out.println(new Solution().lowestCommonAncestor(treeNode1, treeNode5, treeNode3).val);
    }

    static class Solution {


        private TreeNode treeNode;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 注意root为空
            func(root, p, q);
            return treeNode;
        }


        boolean func(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }

            int left = func(root.left, p, q) ? 1 : 0;
            int mid = root == p || root == q ? 1 : 0;
            int right = func(root.right, p, q) ? 1 : 0;
            if (left + mid + right > 2) {
                treeNode = root;
                return true;
            }

            return (mid + left + right) > 0;
        }
    }

}
