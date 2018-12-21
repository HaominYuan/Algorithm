package leetcode;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        node7.next = node8;
        System.out.println(new MySolution().getIntersectionNode(node1, node6));
    }

    static class MySolution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode last = headB;
            while (last.next != null) {
                last = last.next;
            }
            last.next = headB;

            ListNode fast = headA;
            ListNode slow = headA;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = headA;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    last.next = null;
                    return fast;
                }
            }
            last.next = null;
            return null;
        }
    }


    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while(pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}

