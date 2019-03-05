package connectivity;

import java.util.*;

public class UnionFindBase implements CalBridge {

    private Graph graph;
    private Integer[] par;
    private Integer[] dsu_2ecc;
    private Integer[] dsu_cc;
    private Integer[] dsu_cc_size;
    private int lca_iteration;
    private Integer[] last_visit;
    private int bridges;


    public UnionFindBase(Graph graph) {
        this.graph = graph;
        lca_iteration = 0;
        par = new Integer[graph.getVertexNumber()];
        dsu_2ecc = new Integer[graph.getVertexNumber()];
        dsu_cc = new Integer[graph.getVertexNumber()];
        dsu_cc_size = new Integer[graph.getVertexNumber()];
        last_visit = new Integer[graph.getVertexNumber()];
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            // 自己的父亲是本身
            dsu_2ecc[i] = i;
            dsu_cc[i] = i;
            dsu_cc_size[i] = 1;

            par[i] = -1;
            last_visit[i] = 0;
        }
    }

    @Override
    public int calBridge() {
        List<Integer[]> list = graph.getList();
        for (Integer[] integers : list) {
            add_edge(integers[0], integers[1]);
        }

        return bridges;
    }


    private int find_2ecc(int v) {
        if (v == -1)
            return -1;
        // 复制操作包含路径压缩
        return dsu_2ecc[v] == v ? v : (dsu_2ecc[v] = find_2ecc(dsu_2ecc[v]));
    }

    private int find_cc(int v) {
        //先找一个环中的父亲节点
        v = find_2ecc(v);
        // 复制操作的意义是路径压缩
        return dsu_cc[v] == v ? v : (dsu_cc[v] = find_cc(dsu_cc[v]));
    }

    private void make_root(int v) {
        // 翻转链表
        v = find_2ecc(v);
        int root = v;
        int child = -1;
        while (v != -1) {
            int p = find_2ecc(par[v]);
            par[v] = child;
            dsu_cc[v] = root;
            child = v;
            v = p;
        }
        dsu_cc_size[root] = dsu_cc_size[child];
    }

    private void merge_path(int a, int b) {
        lca_iteration = lca_iteration + 1;
        ArrayList<Integer> path_a = new ArrayList<>();
        ArrayList<Integer> path_b = new ArrayList<>();
        int lca = -1;
        while (lca == -1) {
            if (a != -1) {
                a = find_2ecc(a);
                path_a.add(a);
                if (last_visit[a] == lca_iteration)
                    lca = a;
                last_visit[a] = lca_iteration;
                a = par[a];
            }
            if (b != -1) {
                b = find_2ecc(b);
                path_b.add(b);
                if (last_visit[b] == lca_iteration)
                    lca = b;
                last_visit[b] = lca_iteration;
                b = par[b];
            }

        }

        for (int v : path_a) {
            dsu_2ecc[v] = lca;
            if (v == lca)
                break;
            bridges = bridges - 1;
        }
        for (int v : path_b) {
            dsu_2ecc[v] = lca;
            if (v == lca)
                break;
            bridges = bridges - 1;
        }
    }

    private void add_edge(int a, int b) {
        // 找环的根
        a = find_2ecc(a);
        b = find_2ecc(b);
        if (a == b)
            return;

        // 找连通图的根
        int ca = find_cc(a);
        int cb = find_cc(b);

        if (ca != cb) {
            bridges = bridges + 1;
            if (dsu_cc_size[ca] > dsu_cc_size[cb]) {
                int temp = a;
                a = b;
                b = temp;

                temp = ca;
                ca = cb;
                cb = temp;
            }
            make_root(a);
            par[a] = dsu_cc[a] = b;
            dsu_cc_size[cb] += dsu_cc_size[a];
        } else {
            merge_path(a, b);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer[] integers : graph.getList()) {
            if (find_2ecc(integers[0]) != find_2ecc(integers[1])) {
                stringBuilder.append(Arrays.toString(integers)).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
