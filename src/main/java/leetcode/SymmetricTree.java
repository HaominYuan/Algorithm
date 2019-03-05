package leetcode;

import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new Solution().isSymmetric(treeNode1));
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode cur1 = root;
            TreeNode cur2 = root;
            while (cur1 != null || !stack1.isEmpty()) {
                if (cur1 != null) {
                    if (cur2 == null || cur1.val != cur2.val) {
                        return false;
                    }
                    stack1.push(cur1);
                    cur1 = cur1.left;
                    stack2.push(cur2);
                    cur2 = cur2.right;
                } else {
                    if (cur2 != null) {
                        return false;
                    }
                    cur1 = stack1.pop();
                    cur1 = cur1.right;
                    cur2 = stack2.pop();
                    cur2 = cur2.left;
                }
            }
            return true;
//            return isMirror(root, root);
        }


        private boolean isMirror(TreeNode p, TreeNode q) {
            if (q == null && p == null) {
                return true;
            }

            if (q == null || p == null) {
                return false;
            }

            return p.val == q.val && isMirror(p.right, q.left) && isMirror(p.left, q.right);
        }
    }
}
