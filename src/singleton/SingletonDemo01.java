package singleton;

public class SingletonDemo01 {
    // 类初始化时立刻加载
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01() {
    }

    public static SingletonDemo01 getInstance() {
        return instance;
    }
}


