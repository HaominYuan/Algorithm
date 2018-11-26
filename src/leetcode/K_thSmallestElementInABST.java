package leetcode;

import binarysorttree.BinarySortTree;

import java.util.Stack;

public class K_thSmallestElementInABST {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(2);
        System.out.println(new Solution_R().kthSmallest(tree.getRoot(), 4));
    }

    static class Solution_C {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (--k == 0) {
                        return cur.val;
                    }
                    cur = cur.right;
                }
            }
            return 1;
        }
    }

    static class Solution_R {
        int time = 0;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }
            int left = kthSmallest(root.left, k);
            if (k == ++time) {
                return root.val;
            } else if (k < time) {
                return left;
            }
            return kthSmallest(root.right, k);
        }
    }
}
