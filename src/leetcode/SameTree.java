package leetcode;

import java.util.Stack;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        q1.left = q2;
        q1.right = q3;

        System.out.println(new Solution().isSameTree(p1, q1));
    }

    static class Solution {
        boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q != null) {
                return false;
            }

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode cur1 = p;
            TreeNode cur2 = q;
            while (cur1 != null || !stack1.isEmpty()) {
                if (cur1 != null) {
                    if (cur2 == null || cur1.val != cur2.val) {
                        return false;
                    }
                    stack1.push(cur1);
                    cur1 = cur1.left;
                    stack2.push(cur2);
                    cur2 = cur2.left;
                } else {
                    if (cur2 != null) {
                        return false;
                    }
                    cur1 = stack1.pop();
                    cur1 = cur1.right;
                    cur2 = stack2.pop();
                    cur2 = cur2.right;
                }
            }
            return true;
        }
    }

    static class MySolution {
        boolean isSameTree(TreeNode p, TreeNode q) {
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
