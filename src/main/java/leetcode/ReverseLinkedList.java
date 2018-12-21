package leetcode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(new Solution().reverseList(listNode1));
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            while (head.next != null) {
                ListNode temp = head.next;
                head.next = head.next.next;
                temp.next = dummy.next;
                dummy.next = temp;
            }
            return dummy.next;
        }

    }
}
