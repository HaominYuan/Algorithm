package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
//        System.out.println(new MySolution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
        System.out.println(treeNode);
    }



    static class MySolution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        TreeNode buildTree(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            if (left == right) {
                return new TreeNode(nums[left]);
            }

            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[maxIndex] < nums[i]) {
                    maxIndex = i;
                }
            }
            TreeNode treeNode = new TreeNode(nums[maxIndex]);
            treeNode.left = buildTree(nums, left, maxIndex - 1);
            treeNode.right = buildTree(nums, maxIndex + 1, right);
            return treeNode;
        }
    }

//    [6, 3, 2, 1, 5, 0]
    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] arr) {
            TreeNode[] nArr = new TreeNode[arr.length];
            for (int i = 0; i != arr.length; i++) {
                nArr[i] = new TreeNode(arr[i]);
            }
            Stack<TreeNode> stack = new Stack<>();

            // left
            HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
            for (int i = 0; i != nArr.length; i++) {
                TreeNode curTreeNode = nArr[i];
                while (!stack.isEmpty() && stack.peek().val < curTreeNode.val) {
                    popStackSetMap(stack, lBigMap);
                }
                stack.push(curTreeNode);
            }
            while (!stack.isEmpty()) {
                popStackSetMap(stack, lBigMap);
            }

            // right
            // stack内一定没有元素，因为从上面循环出来就一定是空
            HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();
            for (int i = nArr.length - 1; i != -1; i--) {
                TreeNode curTreeNode = nArr[i];
                while (!stack.isEmpty() && stack.peek().val < curTreeNode.val) {
                    popStackSetMap(stack, rBigMap);
                }
                stack.push(curTreeNode);
            }
            while (!stack.isEmpty()) {
                popStackSetMap(stack, rBigMap);
            }

            TreeNode head = null;
            for (int i = 0; i != arr.length; i++) {
                TreeNode curNode = nArr[i];
                TreeNode left = lBigMap.get(curNode);
                TreeNode right = rBigMap.get(curNode);
                if (left == null && right == null) {
                    head = curNode;
                } else if (left == null) {
                    right.left = curNode;
                } else if (right == null) {
                    left.right = curNode;
                } else {
                    if (left.val < right.val) {
                        left.right = curNode;
                    } else {
                        right.left = curNode;
                    }
                }
            }
            return head;
        }

        private void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
            TreeNode popNode = stack.pop();
            if (stack.isEmpty()) {
                map.put(popNode, null);
            } else {
                map.put(popNode, stack.peek());
            }
        }
    }

}
