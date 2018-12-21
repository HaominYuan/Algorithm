package leetcode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
        System.out.println(new Solution().sumNumbers(treeNode1));
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return func(root, 0);
        }

        int func(TreeNode root, int number) {
            if (root == null) {
                return 0;
            }
            int curNumber = number * 10 + root.val;

            if (root.left == null && root.right == null) {
                return curNumber;
            }
            return func(root.left, curNumber) + func(root.right, curNumber);
        }
    }
}
