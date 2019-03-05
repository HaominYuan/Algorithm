package leetcode;

public class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        RandomListNode p = this;
        StringBuilder string = new StringBuilder();
        while (p != null) {
            string.append(format(p)).append("\n");
            p = p.next;
        }
        return string.toString();
    }

    private String format(RandomListNode p) {
        StringBuilder string = new StringBuilder();
        string.append("label：").append(p.label);
        string.append(", next：");
        if (p.next == null) {
            string.append("null");
        } else {
            string.append(p.next.label);
        }
        string.append(", random：");
        if (p.random == null) {
            string.append("null");
        } else {
            string.append(p.random.label);
        }
        return string.toString();
    }
}
