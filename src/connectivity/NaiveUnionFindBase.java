package connectivity;

import java.util.List;

public class NaiveUnionFindBase implements CalBridge{
    private Graph graph;

    public NaiveUnionFindBase(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int calBridge() {
        int sum = 0;
        List<Integer[]> list = graph.getList();
        int original = calConnectedComponent(list);
        for (int i = 0; i < list.size(); i++) {
            Integer[] temp = list.remove(0);
            if (original < calConnectedComponent(list)) {
                sum = sum + 1;
            }
            list.add(temp);
        }
        return sum;
    }

    private int calConnectedComponent(List<Integer[]> list) {
        int father[] = new int[graph.getVertexNumber()];
        int size[] = new int[graph.getVertexNumber()];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
            size[i] = 1;
        }
        for (Integer[] aList : list) {
            int father1 = find(father, aList[0]);
            int father2 = find(father, aList[1]);
            if (father1 != father2) {

                if (size[father1] > size[father2]) {
                    father[father2] = father1;
                    size[father1] = size[father1] + size[father2];
                } else {
                    father[father1] = father2;
                    size[father2] = size[father1] + size[father2];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < father.length; i++) {
            if (father[i] == i) {
                sum = sum + 1;
            }
        }
        return sum;
    }



    private int find(int[] father, int x) {
        if (x == father[x]) {
            return x;
        }
//        路径压缩
        return father[x] = find(father, father[x]);
    }

}
