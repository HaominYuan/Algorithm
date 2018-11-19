package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;



    BinarySortTree() {
        root = new TreeNode(0);
    }

    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    void insert(int value) {
        root.left = insert(root.left, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.val) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        root.val = root.val + 1;
        return node;
    }

    List<Integer> inorderTraversal() {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root.left;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }

    int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    int searchMin() {
        if (root.val == 0) {
            return Integer.MAX_VALUE;
        }
        TreeNode p = root.left;
        while (p.left != null) {
            p = p.left;
        }
        return p.val;
    }

    boolean isContain(int value) {
        return isContain(root.left, value);
    }

    private boolean isContain(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }

        if (value < node.val) {
            return isContain(node.left, value);
        }

        return isContain(node.right, value);
    }

    boolean delete(int value) {
        TreeNode p = root.left;
        pre = root;
        boolean direction = true;
        // 寻找他的父节点
        while (p != null) {
            if (p.val == value) {
                delete(p, direction);
                root.val = root.val - 1;
            }
            pre = p;
            if (value < p.val) {
                direction = true;
                p = p.left;
            } else {
                direction = false;
                p = p.right;
            }
        }
        return false;
    }

    private void delete(TreeNode p, boolean direction) {
        // 删除根节点
        if (root.val == 1) {
            root.left = null;
            return;
        }

        // 都为空
        if (p.left == null && p.right == null) {
            assist(direction, null);
            return;
        }

        // 左边为空
        if (p.left == null) {
            assist(direction, p.right);
            return;
        }

        // 右边为空
        if (p.right == null) {
            assist(direction, p.left);
            return;
        }

        // 都不为空
        TreeNode rightMinPre = null;
        TreeNode rightMinP = p.right;
        while (rightMinP.left != null) {
            rightMinPre = rightMinP;
            rightMinP = rightMinP.left;
        }
        assist(direction, rightMinP);
        rightMinP.left = p.left;
        if (rightMinPre != null) {
            rightMinP.right = p.right;
            rightMinPre.left = null;
        }

    }

    private void assist(boolean direction, TreeNode p) {
        if (direction) {
            pre.left = p;
        } else {
            pre.right = p;
        }
    }

}
