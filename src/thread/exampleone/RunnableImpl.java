package thread.exampleone;

public class RunnableImpl implements Runnable {
    private String name;


    public RunnableImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 100000000; k++);
            System.out.println(name + ":" + i);
        }
    }
}

