package tree.redblacktree;

public class Node {
    public int val;
    public Node left, right;
    public int N;
    public boolean color;

    public Node(int val, boolean color) {
        this.val = val;
        this.color = color;
        this.N = 1;
    }


}
