package leetcode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode15 = new TreeNode(15);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        treeNode6.left = treeNode12;
        treeNode6.right = treeNode13;
        treeNode7.left = treeNode14;
        treeNode7.right = treeNode15;
        System.out.println(new Solution().zigzagLevelOrder(treeNode1));
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            List<TreeNode> assistList = new ArrayList<>();
            boolean direction = true;
            while (!stack.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                assistList.clear();
                while (!stack.isEmpty()) {
                    TreeNode temp = stack.pop();
                    list.add(temp.val);
                    Stack<TreeNode> l = new Stack<>();
                    if (direction) {
                        if (temp.left != null) {
                            l.add(temp.left);
                        }
                        if (temp.right != null) {
                            l.add(temp.right);
                        }
                    }else{
                        if (temp.right != null) {
                            l.add(temp.right);
                        }
                        if (temp.left != null) {
                            l.add(temp.left);
                        }
                    }
                    assistList.addAll(l);
                }
                lists.add(list);
                direction = !direction;
                stack.addAll(assistList);
            }
            return lists;
        }
    }
}
