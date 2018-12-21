package leetcode;

public class ReverseLinkedListII {
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
        System.out.println(new Solution().reverseBetween(listNode1, 2, 4));
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }

            ListNode p = pre.next;
            ListNode temp;
            for (int i = 0; i < n - m; i++) {
                temp = p.next;
                p.next = p.next.next;
                temp.next = pre.next;
                pre.next = temp;
            }

            return dummy.next;
        }
    }
}
