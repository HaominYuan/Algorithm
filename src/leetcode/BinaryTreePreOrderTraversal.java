package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        System.out.println(new Solution().preorderTraversal(treeNode1));
    }

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> treeNodes = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !treeNodes.isEmpty()) {
                if (cur != null) {
                    list.add(cur.val);
                    treeNodes.push(cur);
                    cur = cur.left;
                } else {
                    cur = treeNodes.pop();
                    cur = cur.right;
                }

            }
            return list;
        }
    }
}
