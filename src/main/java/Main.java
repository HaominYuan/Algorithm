import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        HashMap<TreeNode, TreeNode> map = getLeftBigMap(array);
        for (Map.Entry<TreeNode, TreeNode> entry : map.entrySet()) {
            System.out.print(entry.getKey().val + " -> ");
            if (entry.getValue() == null) {
                System.out.println("null");
            } else {
                System.out.println(+entry.getValue().val);
            }
        }
    }

    private static HashMap<TreeNode, TreeNode> getLeftBigMap(int[] array) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        for (int i1 : array) {
            while (!stack.isEmpty() && stack.peek().val < i1) {
                popAndSetMap(stack, map);
            }
            stack.push(new TreeNode(i1));
        }
        while (!stack.isEmpty()) {
            popAndSetMap(stack, map);
        }
        return map;
    }


    private static void popAndSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        // 如果栈是空的，抛出异常
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        TreeNode temp = stack.pop();
        if (stack.isEmpty()) {
            map.put(temp, null);
        } else {
            map.put(temp, stack.peek());
        }
    }


}