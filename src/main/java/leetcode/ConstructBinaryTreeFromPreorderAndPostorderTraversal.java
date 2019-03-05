package leetcode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
//        pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
        System.out.println(new Solution().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}));
    }

    static class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return construct(pre, post, 0, pre.length - 1, 0, post.length - 1);
        }

        TreeNode construct(int[] pre, int[] post, int index11, int index12, int index21, int index22) {
            TreeNode root = new TreeNode(pre[index11]);
            if (index11 == pre.length - 1) {
                return root;
            }

            int index;
            for (index = index22 - 1; index >= index21; index--) {
                if (post[index] == pre[index11 + 1]) {
                    int temp = index11 + 1 + index - index21;
                    root.left = construct(pre, post, index11 + 1, temp, index21, index);
                    if (temp < index12) {
                        root.right = construct(pre, post, index11 + 1 + index - index21 + 1, index12, index + 1, index22 - 1);
                    }
                    break;
                }
            }
            return root;
        }

    }
}
