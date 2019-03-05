package csp;

import java.util.Stack;

class Step implements Cloneable {
    int score;
    Stack<Operation> operations = new Stack<>();

    @Override
    public String toString() {
        return "Step{" +
                "score=" + score +
                ", operations=" + operations +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Step copy = new Step();
        copy.score = score;
        copy.operations = (Stack<Operation>) operations.clone();
        return copy;
    }
}
