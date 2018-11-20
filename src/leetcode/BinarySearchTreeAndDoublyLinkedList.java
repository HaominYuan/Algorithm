package leetcode;

import binarysorttree.BinarySortTree;

public class BinarySearchTreeAndDoublyLinkedList {

    public static void main(String[] args) {
        BinarySortTree root = new BinarySortTree();
        root.insert(10);
        root.insert(6);
        root.insert(4);
        root.insert(8);
        root.insert(14);
        root.insert(12);
        root.insert(16);
        System.out.println(root.inorderTraversalR());
        new BinarySearchTreeAndDoublyLinkedList().convert(root.getRoot());
        TreeNode p = dummy.right;
        while (p != null) {
            System.out.println(p.val);
            p = p.right;
        }
        System.out.println("------");
        while (pre != dummy) {
            System.out.println(pre.val);
            pre = pre.left;
        }
    }


    private static TreeNode dummy = new TreeNode(0);
    private static TreeNode pre = dummy;


    void convert(TreeNode root) {
        if (root.left != null) {
            convert(root.left);
        }
        pre.right = root;
        root.left = pre;
        pre = pre.right;

        if (root.right != null) {
            convert(root.right);
        }
    }
}
