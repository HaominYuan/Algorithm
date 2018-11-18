package leetcode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(4);
        TreeNode treeNode13 = new TreeNode(5);
        TreeNode treeNode14 = new TreeNode(1);
        TreeNode treeNode15 = new TreeNode(2);

        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode12.left = treeNode14;
        treeNode12.right = treeNode15;


        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(1);
        TreeNode treeNode23 = new TreeNode(2);

        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        System.out.println(new Solution().isSubtree(treeNode11, treeNode21));
    }

    static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return s != null && (isSameTree(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t));
        }


        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
