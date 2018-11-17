package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Crack {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException, ClassNotFoundException {
        SingletonDemo02 singletonDemo02 = SingletonDemo02.getInstance();
        SingletonDemo02 singletonDemo021 = singletonDemo02.getInstance();

        System.out.println(singletonDemo02);
        System.out.println(singletonDemo021);


        // 反射破解
        Class<SingletonDemo02> clazz = SingletonDemo02.class;
        Constructor<SingletonDemo02> constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingletonDemo02 singletonDemo022 = constructor.newInstance();
        SingletonDemo02 singletonDemo023 = constructor.newInstance();
        System.out.println(singletonDemo022);
        System.out.println(singletonDemo023);

        // 反序列化破解
        FileOutputStream fileOutputStream = new FileOutputStream("src/design/singleton/1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(singletonDemo02);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("src/design/singleton/1");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SingletonDemo02 singletonDemo024 = (SingletonDemo02) objectInputStream.readObject();
        System.out.println(singletonDemo024);
    }
}
