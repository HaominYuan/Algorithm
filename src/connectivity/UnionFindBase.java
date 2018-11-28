package connectivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionFindBase implements CalBridge {

    private Graph graph;
    private Integer[] par;
    private Integer[] dsu_2ecc;
    private Integer[] dsu_cc;
    private Integer[] dsu_cc_size;
    private int lca_iteration;
    private Integer[] last_visit;
    private Set<Integer> bridges;
    private int vertexNumber;


    public UnionFindBase(Graph graph) {
        this.graph = graph;
        lca_iteration = 0;
        par = new Integer[graph.getVertex()];
        dsu_2ecc = new Integer[graph.getVertex()];
        dsu_cc = new Integer[graph.getVertex()];
        dsu_cc_size = new Integer[graph.getVertex()];
        last_visit = new Integer[graph.getVertex()];
        bridges = new HashSet<>();
        vertexNumber = graph.getVertex();
        for (int i = 0; i < graph.getVertex(); i++) {
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
        System.out.println(bridges);

        for (Integer bridge : bridges) {
            System.out.println(bridge / vertexNumber + "<->" + bridge % vertexNumber);
        }

        return bridges.size();
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
        // 使得某个节点变为根，相当于链表翻转
        int root = v;
        int child = -1;
        int count = 0;
        while (v != -1) {
            // 找这个节点的根
            int p = find_2ecc(par[v]);
            par[v] = child;
            dsu_cc[v] = root;
            child = v;
            v = p;
        }
        dsu_cc_size[root] = dsu_cc_size[child];
    }

    private void merge_path(int a, int b) {
        // 标记加1，到时候合并节点的时候用
        lca_iteration = lca_iteration + 1;
        // a节点经过的点
        ArrayList<Integer> path_a = new ArrayList<>();
        path_a.add(a);
        // b节点经过的点
        ArrayList<Integer> path_b = new ArrayList<>();
        path_b.add(b);
        // 首先设置父亲为-1
        int lca = -1;
        while (lca == -1) {

            if (a != -1) {
                // 找他的环的根节点
                a = find_2ecc(a);
                // 然后把他加入到路径中
                path_a.add(a);
                // 如果下一个点被另外一个节点经过，那么找到根节点
                if (last_visit[a] == lca_iteration) {
                    lca = a;
                }
                last_visit[a] = lca_iteration;
                // 指针向前移动一步
                a = par[a];
            }

            // b的情况和a类似
            if (b != -1) {
                b = find_2ecc(b);
                path_b.add(b);
                if (last_visit[b] == lca_iteration) {
                    lca = b;
                }
                last_visit[b] = lca_iteration;
                b = par[b];
            }
        }

        // 路径压缩，将路径上的所有点进行压缩
        for (int i = 0; i < path_a.size() && path_a.get(i) != lca; i++) {
            dsu_2ecc[path_a.get(i)] = lca;
            deleteBridge(path_a.get(i), path_a.get(i + 1));
        }

        for (int i = 0; i < path_b.size() && path_b.get(i) != lca; i++) {
            dsu_2ecc[path_b.get(i)] = lca;
            deleteBridge(path_b.get(i), path_b.get(i + 1));
        }
    }


    private void deleteBridge(int a, int b) {
        bridges.remove(a * vertexNumber + b);
        bridges.remove(b * vertexNumber + a);

    }

    private void add_edge(int a, int b) {
        int copy1 = a;
        int copy2 = b;
        // 判断是否在同一个环中
        a = find_2ecc(a);
        b = find_2ecc(b);
        if (a == b)
            return;

        int ca = find_cc(a);
        int cb = find_cc(b);

        // 判断是否处于同一个连通图中
        if (ca != cb) {
            // 不在同一个连通图中，意味着添加的边就是桥
            // 比较树的大小，将小的树连在大的树后面
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

            // 树的大小改变
            dsu_cc_size[cb] = dsu_cc_size[cb] + dsu_cc_size[a];
            if (copy1 < copy2) {
                bridges.add(vertexNumber * copy1 + copy2);
            } else {
                bridges.add(vertexNumber * copy2 + copy1);
            }

        } else {

            // 在同一个连通图中需要缩边
            merge_path(a, b);
        }
    }
}
