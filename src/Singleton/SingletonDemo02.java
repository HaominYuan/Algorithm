package Singleton;

import java.io.Serializable;

class SingletonDemo02 implements Serializable {

    //只有等到调用的时候在初始化这个对象
    private static SingletonDemo02 instance;

    // 防止反射调用构造和防止构造
    private SingletonDemo02(){
        if (instance != null) {
            throw new RuntimeException();
        }
    }

//    这里加上synchronized可以用于多线程的程序，但是这样效率太低
//    加入已经创建好了对象，就不需要用synchronized
    static synchronized SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }

    // 防止反序列化
    private Object readResolve() {
        return instance;
    }
}
