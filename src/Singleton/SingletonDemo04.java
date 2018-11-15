package Singleton;

public class SingletonDemo04 {
    private static class Instance {
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    private SingletonDemo04(){}

    public static SingletonDemo04 getInstance() {
        return Instance.instance;
    }
}
