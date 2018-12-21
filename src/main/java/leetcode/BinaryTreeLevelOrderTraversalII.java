package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(17);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(new Solution().levelOrderBottom(treeNode1));
    }

    static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            func(lists, 0, root);
            for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
                List<Integer> temp = lists.get(i);
                lists.set(i, lists.get(j));
                lists.set(j, temp);
            }
            return lists;
        }

        private void func(List<List<Integer>> lists, int level, TreeNode root) {
            if (root == null) {
                return;
            }
            if (lists.size() == level) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
            } else {
                lists.get(level).add(root.val);
            }
            func(lists, level + 1, root.left);
            func(lists, level + 1, root.right);
        }
    }
}
