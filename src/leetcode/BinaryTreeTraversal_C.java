package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 代码和解释参考抄袭 https://juejin.im/post/59e3fde451882578c20858a5
 */

public class BinaryTreeTraversal_C {
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
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    list.add(cur.val);
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                cur = cur.right;
            }
            return list;
        }
    }

    static class Inorder {
        List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
            return list;
        }
    }

    static class Postorder {

        List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            TreeNode cur = root;
            TreeNode last = null;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }

                cur = stack.peek();
                if (cur.right == null || cur.right == last) {
                    stack.pop();
                    list.add(cur.val);
                    last = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
            return list;
        }
    }
}
