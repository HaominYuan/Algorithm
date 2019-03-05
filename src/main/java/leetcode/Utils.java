package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Utils {

    static TreeNode constructTree(int[] list) {
        if (list.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 1;
        while (i < list.length) {
            TreeNode node = queue.remove();
            if (list[i] != Integer.MAX_VALUE) {
                node.left = new TreeNode(list[i]);
                queue.add(node.left);
            }else{
                queue.add(new TreeNode(1));
            }
            i = i + 1;
            if (list[i] != Integer.MAX_VALUE) {
                node.right = new TreeNode(list[i]);
                queue.add(node.right);
            } else {
                queue.add(new TreeNode(1));
            }
            i = i + 1;
        }
        return root;
    }
}
