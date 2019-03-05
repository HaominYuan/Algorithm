package leetcode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{1, 2}, new int[]{2, 1}));
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) {
                return null;
            }
            return func(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode func(int[] inorder, int[] postorder, int begin1, int end1, int begin2, int end2) {
            if (end2 < begin2) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[end2]);
            if (begin1 == end1) {
                return root;
            }

            int index;
            for (index = end1; index >= begin1; index--) {
                if (postorder[end2] == inorder[index]) {
                    root.left = func(inorder, postorder, begin1, index - 1, begin2, begin2 + index - begin1 - 1);
                    root.right = func(inorder, postorder, index + 1, end1, begin2 + index - begin1, end2 - 1);
                    return root;
                }
            }
            return null;
        }
    }
}
