package singleton;


public class SingletonDemo03 {

    private static SingletonDemo03 instance;

    private SingletonDemo03() {
    }

//    这里内层需要加上判断是否为空是因为防止第二个线程进入然后重新new了一个实例
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
