package priorityqueue;

public class PriorityQueue {
    public static void main(String[] args) {
        java.util.PriorityQueue qu = new java.util.PriorityQueue();
        qu.add(5);
        qu.add(3);
        qu.add(2);
        qu.add(4);
        qu.add(1);
        System.out.println(qu.remove(2));
        while (!qu.isEmpty()) {
            System.out.println(qu.poll());
        }
    }
}
