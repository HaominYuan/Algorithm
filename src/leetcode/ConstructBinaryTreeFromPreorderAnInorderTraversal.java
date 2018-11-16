package leetcode;

public class ConstructBinaryTreeFromPreorderAnInorderTraversal {
    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{1, 2}, new int[]{1, 2}));
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            return func(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode func(int[] preorder, int[] inorder, int begin1, int end1, int begin2, int end2) {
            if (begin1 == preorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[begin1]);
            if (begin1 == end1) {
                return root;
            }

            for (int index = end2; index >= begin2; index--) {
                if (preorder[begin1] == inorder[index]) {
                    int length = index - begin2;
                    root.left = func(preorder, inorder, begin1 + 1, begin1 + length, begin2, index - 1);
                    root.right = func(preorder, inorder, begin1 + length + 1, end1, index + 1, end2);
                    return root;
                }
            }
            return null;
        }
    }
}
