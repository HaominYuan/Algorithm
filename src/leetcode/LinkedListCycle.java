package leetcode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode1;
        System.out.println(new MySolution().hasCycle(listNode1));
    }


    /**
     * 判断是否有环原理如下：
     * 当第一次相遇时
     * slow指针走过的路径长度为S = m + A * n + k
     * fast指针走过的路径长度为2S = m + B * n + k
     * 其中m为从起点到换的起点的位置的长度，n为环的长度，k为指针从环起点到指针的长度
     * fast指针走过的路径长度减去slow指针走过的路径的长度为S = (B - A) * n，可以看出S是圈的整数倍。
     * 然后让slow指针从起点走m到环的起点，fast指针也以顺着环走m步。
     * 此时fast指针已经走了2S + m步，可以等价的看成fast指针先走了m步到环的起点，然后顺着环转了2 * (B - A)圈
     * 虽然目前不知道m的具体数值，但是可以用slow和fast指针相遇的时候来判断fast指针是否到了环的起点。
     */

    static public class MySolution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == head) {
                return true;
            }
            ListNode l = head.next;
            head.next = head;
            return hasCycle(l);
        }
    }


}
