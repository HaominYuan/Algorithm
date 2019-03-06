package tree.redblacktree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static tree.redblacktree.Constant.BLACK;
import static tree.redblacktree.Constant.RED;

public class RedBlackBST {

    private Node root;

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        RedBlackBST redBlackBST = new RedBlackBST();
        for (int i = 0; i < 10; i++) {
            int temp = (int) (Math.random() * 100);
            redBlackBST.put(temp);
            list.add(temp);
        }
        System.out.println(list);
        System.out.println(redBlackBST.inorderTreeC());
    }

    private boolean isRed(Node cur) {
        if (cur == null) {
            return false;
        }

        return cur.color == RED;
    }

    private Node rotateLeft(Node cur) {
        Node right = cur.right;
        cur.right = right.left;
        right.left = cur;
        right.color = cur.color;
        cur.color = RED;
        right.N = cur.N;
        cur.N = size(cur.left) + size(cur.right) + 1;
        return right;
    }

    private Node rotateRight(Node cur) {
        Node left = cur.left;
        cur.left = left.right;
        left.right = cur;
        left.color = cur.color;
        cur.color = RED;
        left.N = cur.N;
        cur.N = size(cur.left) + size(cur.right) + 1;
        return left;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = h.right.color = BLACK;
    }

    private int size(Node cur) {
        if (cur == null) {
            return 0;
        }
        return cur.N;
    }

    public void put(int val) {
        root = put(root, val);
        root.color = BLACK;
    }

    private Node put(Node cur, int val) {
        if (cur == null) {
            return new Node(val, RED);
        }

        if (val < cur.val) {
            cur.left = put(cur.left, val);
        } else if (val > cur.val) {
            cur.right = put(cur.right, val);
        }

        if (!isRed(cur.left) && isRed(cur.right)) {
            cur = rotateLeft(cur);
        }
        if (isRed(cur.left) && isRed(cur.left.left)) {
            cur = rotateRight(cur);
        }
        if (isRed(cur.left) && isRed(cur.right)) {
            flipColors(cur);
        }

        return cur;

    }

    private List<Integer> inorderTreeC() {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
