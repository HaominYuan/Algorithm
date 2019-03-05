package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
//        [3,9,20,null,null,15,7]
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(17);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(new MySolution().levelOrder(treeNode1));
    }

    static class MySolution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int lastSize = 1, size = 0;
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < lastSize; i++) {
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left != null) {
                        queue.add(temp.left);
                        size = size + 1;
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                        size = size + 1;
                    }
                }
                lists.add(list);
                lastSize = size;
                size = 0;
            }
            return lists;
        }
    }


    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            func(lists, 0, root);
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
