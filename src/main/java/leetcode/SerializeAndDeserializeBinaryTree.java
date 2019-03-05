package leetcode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        Codec codec = new Codec();
        System.out.println(codec.deserialize(codec.serialize(t1)));
    }

    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "$,";
            }
            return root.val + "," + serialize(root.left) + serialize(root.right);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            Queue<String> queue = new ArrayDeque<>(Arrays.asList(strings));
            return func(queue);
        }


        private TreeNode func(Queue<String> strings) {
            String string = strings.remove();
            if ("$".equals(string)) {
                return null;
            }
            TreeNode newNode = new TreeNode(Integer.parseInt(string));
            newNode.left = func(strings);
            newNode.right = func(strings);
            return newNode;
        }

    }
}
