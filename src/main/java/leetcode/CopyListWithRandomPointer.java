package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node4.random = node2;
        System.out.println(new Solution().copyRandomList(node1));
    }

    static class MySolution {
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode dummy = new RandomListNode(-1);
            RandomListNode pre = dummy, p = head, tmp;
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            while (p != null) {
                pre.next = new RandomListNode(p.label);
                pre = pre.next;
                map.put(p, pre);
                p = p.next;
            }
            p = head;
            pre = dummy.next;
            while (p != null) {
                if (p.random != null) {
                    pre.random = map.get(p.random);
                }
                p = p.next;
                pre = pre.next;
            }
            return dummy.next;
        }
    }

    static class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode p = head, tmp;
            while (p != null) {
                tmp = new RandomListNode(p.label);
                tmp.next = p.next;
                p.next = tmp;
                p = p.next.next;
            }
            p = head;
            while (p != null) {
                tmp = p.next;
                if (p.random != null) {
                    tmp.random = p.random.next;
                }
                p = p.next.next;
            }
            RandomListNode dummy = new RandomListNode(0);
            dummy.next = head;
            RandomListNode pre = dummy;
            p = head;
            while (p != null) {
                pre.next = p.next;
                p.next = p.next.next;
                p = p.next;
                pre = pre.next;
            }
            return dummy.next;
        }
    }

}
