package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal_R {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(new Preorder().preorderTraversal(treeNode1));
        System.out.println(new Inorder().inorderTraversal(treeNode1));
        System.out.println(new Postorder().postorderTraversal(treeNode1));
    }

    static class Preorder {

        List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            func(list, root);
            return list;
        }

        private void func(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            func(list, root.left);
            func(list, root.right);
        }
    }

    static class Inorder {

        List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            func(list, root);
            return list;
        }

        void func(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            func(list, root.left);
            list.add(root.val);
            func(list, root.right);
        }
    }

    static class Postorder {

         List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            func(list, root);
            return list;
        }

        void func(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            func(list, root.left);
            func(list, root.right);
            list.add(root.val);
        }

    }
}
