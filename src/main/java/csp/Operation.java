package csp;

class Operation implements Cloneable {
    private int x;
    private int y;
    private int direction;


    public Operation() {
    }

    Operation(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
