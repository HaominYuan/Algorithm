package singleton;

public class Recall {
    private static Recall instance;

    private Recall() { }

    public synchronized static Recall getInstance() {
        if (instance == null) {
            synchronized (Recall.class) {
                if (instance == null) {
                    instance = new Recall();
                }
            }
        }

        return instance;
    }
}
