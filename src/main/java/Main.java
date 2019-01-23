import java.util.*;

public class Main {

    private static int lenVertice = 5;   //点的个数
    private static int lenEdge = 7;   //边的个数
    private static boolean[] isVisited = new boolean[lenVertice];  //DFS中被访问的点
    private static Vertex[] vertices = new Vertex[lenVertice];  //存放点
    private static Stack<Vertex> s = new Stack<>();  //非递归DFS的栈
    private static Stack<Integer> stack = new Stack<>();  //存放拓扑排序

    private static Vertex[] verTranslate = new Vertex[lenVertice];  //存放点
    private static boolean[] isVisitedTranslate = new boolean[lenVertice];  //BFS中被访问的点
    private static Stack<Integer> reverseStack = new Stack<>();  //非递归DFS的栈


    private static void csh() {
        // 构造点
        for (int i = 0; i < lenVertice; i++) {
            vertices[i] = new Vertex(i);
        }

        // 构建边
        Set<Edge> edges = new HashSet<>();

        while (edges.size() < lenEdge) {
            int u = random();
            int v = random();

            while (u == v || edges.contains(new Edge(u, v))) {
                v = random();
            }

            edges.add(new Edge(u, v));

        }

        //将边加到对应的起始点的链表中
        for (Edge edge : edges) {
            vertices[edge.u].list.add(edge.v);
        }
    }

    // 重新初始化BFS和DFS标注点
    private static void csh1() {
        for (int i = 0; i < lenVertice; i++) {
            isVisited[i] = false;
        }
    }

    private static void display(Vertex[] ver) {
        System.out.println("打印所有点的邻接链表：");
        //打印所有的邻接链表
        for (int i = 0; i < lenVertice; i++) {
            int len = ver[i].list.size();
            System.out.print(ver[i].n + "-->");

            for (int j = 0; j < len; j++)
                System.out.print(ver[i].list.get(j) + "-->");

            System.out.println("");
        }

    }

    // 生成1-100随机数
    public static int random() {
        return (int) (Math.random() * lenVertice);
    }

    //非递归DFS
    private static void dfs(Vertex v) {
        isVisited[v.n] = true;  //将参数中对应点标为已读
        s.add(v);  //将初始点加入栈中

        while (!s.empty()) {
            int i = 0;  //现在搜寻点邻接链表中的第一个邻接点
            while (i < v.list.size()) {
                Vertex temp = vertices[v.list.get(i)]; //定义为该点的下一个点
                if (!isVisited[temp.n]) {
                    s.add(temp);  //将该点邻接表中第一个（未读）邻接点放入栈中
                    i = 0;
                    isVisited[temp.n] = true; //把刚才放入的点标记为已读
                } else {
                    i = i + 1;  //若第i个点已读，继续寻找未读邻接点
                }
                v = s.peek();  // v=刚才放入的那个点（即继续向下一层进行while寻找）
            }

            if (!stack.contains(v.n)) {
                stack.push(v.n);  //拓扑排序放进栈里
            }

            s.pop();  //这一条深度搜寻链已到底，将最底下的那个点从栈中删除

            if (!s.empty()) {

                v = s.peek();  //回溯到上一个点
            }
        }
    }

    //反转图DFS
    private static void reverseDFS(Vertex v) {
        isVisitedTranslate[v.n] = true;  //将参数中对应点标为已读
        reverseStack.push(v.n);   //将已遍历过的强连通分量的点入栈

        System.out.print(v.n + ",");

        //接下来的操作针对的是该点的邻接链表中的点（除自身）
        for (int i = 0; i < v.list.size(); i++) {
            Vertex temp = verTranslate[v.list.get(i)];
            if (!isVisitedTranslate[temp.n]) {
                reverseDFS(temp);
            }
        }
    }


    //反转图
    private static void reverse(Vertex[] ver) {
        // 初始化新的节点
        for (int i = 0; i < lenVertice; i++) {
            verTranslate[i] = new Vertex(i);
        }

        for (Vertex vertex : ver) {
            int n = vertex.n;
            List<Integer> list = vertex.list;
            for (Integer integer : list) {
                // 如果不包含
                if (!verTranslate[integer].list.contains(n)) {
                    verTranslate[integer].list.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        csh();  //初始化
        display(vertices);  //打印邻接链表
        System.out.println();

        for (int i = 0; i < lenVertice; i++) {
            if (!s.contains(vertices[i])){
                dfs(vertices[i]);  //DFS并求拓扑
//                reverseDFS(vertices[i]);
            }

        }

        System.out.println("DAG图拓扑排序:" + stack.size());

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(stack.size() - 1 - i) + "-->");
        }

        System.out.println("\n-------图反转-------");
        reverse(vertices);
        display(verTranslate);

        csh1();
        System.out.println("反转图递归DFS求强连通分支:");

        int t = 0;
        while (t < stack.size()) {
            int temp = stack.get(stack.size() - t - 1);
            if (!reverseStack.contains(temp)) {
                System.out.print("(");
                reverseDFS(verTranslate[temp]);//非递归深度优先搜索
                System.out.print(")");
                System.out.println();
            }
            t++;
        }

    }

}