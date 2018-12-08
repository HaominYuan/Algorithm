package maximumflowinaflownetwork;

public class Edge {
    int u, v, capacity, flow;


    public Edge(int u, int v, int capacity, int flow) {

        this.u = u;
        this.v = v;
        this.capacity = capacity;
        this.flow = flow;
    }


}
