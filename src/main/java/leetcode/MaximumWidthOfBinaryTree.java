package leetcode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2 );
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        System.out.println(new Solution().widthOfBinaryTree(treeNode1));
    }

    static class Solution {
        private int max = 0;

        public int widthOfBinaryTree(TreeNode root) {
            func(root, 0, 0, new ArrayList<>(100000));
            return max + 1;
        }

        private void func(TreeNode root, int level, int index, List<Integer> list) {
            if (root == null) {
                return;
            }

            if (list.size() - 1 < level) {
                list.add(index);
            }
            max = Math.max(max, index - list.get(level));
            int temp = 2 * index + 1;
            func(root.left,     level + 1, temp, list);
            func(root.right, level + 1, temp + 1, list);
        }

    }
}
