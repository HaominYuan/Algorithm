package maximumflowinaflownetwork;

public class Graph {
    private boolean[][] E;
    private int[][] C;
    private int edgeNumber;
    private int vertexNumber;

    Graph(int vertexNumber, int edgeNumber) {
        this.edgeNumber = edgeNumber;
        this.vertexNumber = vertexNumber;
        generate();
    }

    public boolean[][] getE() {
        return E;
    }

    public int[][] getC() {
        return C;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    private void generate() {
        E = new boolean[vertexNumber][vertexNumber];
        C = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < edgeNumber; i++) {
            int number1;
            int number2;
            do {
                while ((number1 = (int) (Math.random() * vertexNumber)) == edgeNumber - 1) ;
                while ((number2 = (int) (Math.random() * vertexNumber)) == 0 || number1 == number2) ;
            } while (E[number1][number2]);
            E[number1][number2] = true;
            E[number2][number1] = true;
        }
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (E[i][j]) {
                    int number;
                    while ((number = (int) (Math.random() * (vertexNumber + edgeNumber))) == 0) ;
                    C[i][j] = number;
                }
            }
        }
    }
}
