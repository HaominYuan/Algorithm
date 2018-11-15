package Singleton;


public class SingletonDemo03 {
    //
    private static SingletonDemo03 instance;

    private SingletonDemo03() {
    }

    public static SingletonDemo03 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo03.class) {
                if (instance == null) {
                    instance = new SingletonDemo03();
                }
            }
        }
        return instance;
    }
}
