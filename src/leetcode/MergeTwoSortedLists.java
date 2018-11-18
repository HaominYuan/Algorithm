package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        System.out.println(listNode11);

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);

        listNode21.next = listNode22;
        listNode22.next = listNode23;
        System.out.println(listNode21);

        System.out.println(new Solution().mergeTwoLists(listNode11, listNode21));
    }

//    Input: 1->2->4, 1->3->4
//    Output: 1->1->2->3->4->4


    static class MySolution {
        ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode p = head;
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode temp;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    p.next = new ListNode(p1.val);
                    p1 = p1.next;
                } else {
                    p.next = new ListNode(p2.val);
                    p2 = p2.next;
                }
                p = p.next;
            }
            while (p1 != null) {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            }

            while (p2 != null) {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            }
            return head.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            p.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }
}
