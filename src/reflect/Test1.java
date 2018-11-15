package reflect;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 每个类都会产生一个对应的class对象，也就是保存在.class文件。
        // 所有类都是在对其第一次使用时，动态加载到JVM的，当程序创建一个对应的静态成员的引用时，
        // 就会加载到这个类。class对象仅在需要的时候才会家在，static初始化是在类加载时进行的。
        System.out.println(XYZ.name);
    }
}


class XYZ {
    public static String name = "袁浩民";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }
}
