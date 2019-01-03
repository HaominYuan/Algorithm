//package leetcode;
//
//public class MaximumBinaryTree {
//    public static void main(String[] args) {
//        System.out.println(new NaiveSolution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
//    }
//
//
//    static class NaiveSolution {
//        public TreeNode constructMaximumBinaryTree(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return null;
//            }
//            return func(nums, 0, nums.length - 1);
//        }
//
//        TreeNode func(int[] nums, int left, int right) {
//            if (left == right) {
//                return new TreeNode(nums[left]);
//            }
//
//            int mid = (left + right) / 2;
//            TreeNode leftNode = func(nums, left, mid);
//            TreeNode rightNode = func(nums, mid + 1, right);
//            return insert(leftNode, rightNode);
//        }
//
//        TreeNode insert(TreeNode leftNode, TreeNode rightNode) {
//            if (leftNode == null && rightNode == null) {
//                return null;
//            }
//            if (leftNode == null) {
//                return rightNode;
//            }
//            if (rightNode == null) {
//                return leftNode;
//            }
//            // 假定左子树比较大
//            if (leftNode.val < rightNode.val) {
//                TreeNode temp = leftNode;
//                leftNode = rightNode;
//                rightNode = temp;
//            }
//
//
//        }
//    }
//}
