import java.util.Objects;

class Edge {
    int u;//该点
    int v;//下一个点

    //构造方法
    Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return u == edge.u &&
                v == edge.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(u, v);
    }
}