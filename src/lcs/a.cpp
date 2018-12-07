package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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
    package binarysorttree;

    import leetcode.TreeNode;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinarySortTree {

        private TreeNode root;
        private TreeNode pre;

        public TreeNode getRoot() {

            return root.left;
        }

        public BinarySortTree() {
            root = new TreeNode(0);
        }


        public BinarySortTree(TreeNode root) {
            this();
            this.root.left = root;
        }

        public int getSize() {
            return root.val;
        }

        public void insert(int value) {
            root.left = insert(root.left, value);
            root.val = root.val + 1;
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
            return node;
        }

        public List<Integer> inorderTraversalC() {
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

        public List<Integer> inorderTraversalR() {
            List<Integer> list = new ArrayList<>();
            inorderTraversalR(list, root.left);
            return list;
        }

        private void inorderTraversalR(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversalR(list, root.left);
            list.add(root.val);
            inorderTraversalR(list, root.right);
        }




        public int searchMax() {
            if (root.val == 0) {
                return Integer.MIN_VALUE;
            }
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            return p.val;
        }


        public int searchMin() {
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

package binarysorttree;

import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySortTree {

    private TreeNode root;
    private TreeNode pre;

    public TreeNode getRoot() {

        return root.left;
    }

    public BinarySortTree() {
        root = new TreeNode(0);
    }


    public BinarySortTree(TreeNode root) {
        this();
        this.root.left = root;
    }

    public int getSize() {
        return root.val;
    }

    public void insert(int value) {
        root.left = insert(root.left, value);
        root.val = root.val + 1;
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
        return node;
    }

    public List<Integer> inorderTraversalC() {
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

    public List<Integer> inorderTraversalR() {
        List<Integer> list = new ArrayList<>();
        inorderTraversalR(list, root.left);
        return list;
    }

    private void inorderTraversalR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalR(list, root.left);
        list.add(root.val);
        inorderTraversalR(list, root.right);
    }




    public int searchMax() {
        if (root.val == 0) {
            return Integer.MIN_VALUE;
        }
        TreeNode p = root.left;
        while (p.right != null) {
            p = p.right;
        }
        return p.val;
    }


    public int searchMin() {
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


    }
