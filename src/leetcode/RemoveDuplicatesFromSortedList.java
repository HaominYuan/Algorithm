package leetcode;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println(new Solution().deleteDuplicates(listNode1));
    }





    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode p1 = head;
            ListNode p2 = head.next;
            while (p2 != null) {
                if (p1.val == p2.val) {
                    p1.next = p2.next;
                } else {
                    p1 = p1.next;
                }
                p2 = p2.next;
            }
            return head;

        }
    }
}
