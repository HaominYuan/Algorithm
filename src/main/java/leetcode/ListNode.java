package leetcode;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            stringBuilder.append(p.val).append("->");
            p = p.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
//        return val + "";
    }

    void reverseToString(ListNode p) {
        if (p != null) {
            reverseToString(p.next);
            System.out.println(p.val);
        }
    }
}
