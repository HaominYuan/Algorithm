package leetcode;

public class PathSum {

    public static void main(String[] args) {

//                5
//                / \
//                4   8
//                /   / \
//                11  13  4
//                /  \      \
//                7    2      1


        TreeNode treeNode = Utils.constructTree(new int[]{5, 4, 8, 11, Integer.MAX_VALUE, 13, 4, 7, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1});
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode6.left = treeNode9;

        System.out.println(new Solution().hasPathSum(treeNode, 22));
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum - root.val == 0;
            }
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }
    }
}
