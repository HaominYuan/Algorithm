package tree.binarysearchtree;

import com.sun.source.tree.IfTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySort {
    private Node root;

    public static void main(String[] args) {
        BinarySort binarySort = new BinarySort();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            int temp = (int) (Math.random() * 100);
            binarySort.insert(temp);
            list.add(temp);
        }
        for (Integer integer : list) {
            binarySort.delete(integer);
            System.out.println(binarySort.inorderTraversal());
        }

//        System.out.println(binarySort.inorderTraversal());
//        binarySort.deleteMin();
//        System.out.println(binarySort.inorderTraversal());
//        binarySort.deleteMin();
//        System.out.println(binarySort.inorderTraversal());
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node cur) {
        if (cur == null) {
            return 0;
        }
        return cur.N;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node cur, int value) {
        if (cur == null) {
            return new Node(value);
        }
        if (value < cur.val) {
            cur.left = insert(cur.left, value);
        } else {
            cur.right = insert(cur.right, value);
        }

        cur.N = getSize(cur.left) + getSize(cur.right) + 1;
        return cur;
    }

    public List<Integer> inorderTraversal() {
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

    public int searchMax() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Node cur = root;
        while (cur.right != null) {
            cur = (Node) cur.right;
        }
        return cur.val;
    }

    public int searchMin() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }

    public boolean isContain(int value) {
        return isContain(root, value);
    }

    private boolean isContain(Node cur, int val) {
        if (cur == null) {
            return false;
        }

        if (cur.val == val) {
            return true;
        }

        if (val < cur.val) {
            return isContain(cur.left, val);
        }

        return isContain(cur.right, val);
    }

    public String toString() {
        return inorderTraversal().toString();
    }

    public int min() {
        return min(root).val;
    }

    private Node min(Node cur) {
        if (cur.left == null) {
            return cur;
        }
        return min(cur.left);
    }

    public int floor(int val) {
        Node temp = floor(root, val);
        if (temp == null) {
            return Integer.MAX_VALUE;
        }
        return temp.val;
    }

    private Node floor(Node cur, int val) {
        if (cur == null) {
            return null;
        }
        if (val < cur.val) {
            return floor(cur.left, val);
        }
        if (val > cur.val) {
            return floor(cur.right, val);
        }
        return cur;
    }

    public int select(int k) {
        return select(root, k).val;
    }

    private Node select(Node cur, int k) {
        int leftSize = getSize(cur.left);
        if (leftSize >= k) {
            return select(cur.left, k);
        }

        if (leftSize + 1 == k) {
            return cur;
        }

        return select(cur.right, k - leftSize - 1);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = getSize(x.left) + getSize(x.right) + 1;
        return x;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    public Node delete(Node cur, int val) {
        if (val < cur.val) {
            cur.left = delete(cur.left, val);
        } else if (val > cur.val) {
            cur.right = delete(cur.right, val);
        } else {
            if (cur.left == null) {
                return cur.right;
            }

            if (cur.right == null) {
                return cur.left;
            }
            Node temp = cur;
            cur = min(cur.right);
            cur.right = deleteMin(temp.right);
            cur.left = temp.left;
        }

        return cur;
    }

    public int rank(int val) {
        return rank(root, val);
    }

    private int rank(Node cur, int val) {
        if (cur == null) {
            return 0;
        }

        if (val < cur.val) {
            return rank(cur.left, val);
        }

        if (cur.val == val) {
            return getSize(cur.left) + 1;
        }

        return getSize(cur.left) + 1 + rank(cur.right, val);
    }
}
