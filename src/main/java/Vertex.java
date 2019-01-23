import java.util.LinkedList;
import java.util.List;

public class Vertex {
    int n;//邻接链表的点
    List<Integer> list = new LinkedList<Integer>();

    //点的构造方法
    Vertex(int n) {
        this.n = n;
    }

    //向该点的链表中增加点
    public void add(int value) {
        list.add(value);
    }

}
