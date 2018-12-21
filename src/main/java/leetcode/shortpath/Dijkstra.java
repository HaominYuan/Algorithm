package leetcode.shortpath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        // 将自己到自己的距离设置为零
        source.setDistance(0);
        // 这个是已经确定点的集合
        Set<Node> settledNodes = new HashSet<>();
        // 这个是未确定点的集合
        Set<Node> unsettledNodes = new HashSet<>();

        // 将源点加入未设置点
        unsettledNodes.add(source);

        // 当未确定点的集合为空是意味着所有的点都遍历完了
        while (unsettledNodes.size() != 0) {
            // 从当前未确定的点中找一个离源点最近的点作为下一个点
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            // 将这个点设置为确定的点
            unsettledNodes.remove(currentNode);
            settledNodes.add(currentNode);
            // 遍历与这个点相连的其他节点
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                // 这个点必须未确定过
                if (!settledNodes.contains(adjacentNode)) {
                    // 更新这个点的距离
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    // 然后把更新后的点放入集合中
                    unsettledNodes.add(adjacentNode);
                }
            }
        }
        return graph;
    }

    // 从没有确定的位置去寻找离源点最近的点
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
        for (Node node : nodeE.getShortestPath()) {
            System.out.println(node.getName());
        }
    }
}
