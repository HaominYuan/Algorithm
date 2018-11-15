package proxy;

public class ProxyTest implements Person {
    private Person person;

    public ProxyTest(Person person) {
        this.person = person;
    }

    @Override
    public void sayHello(String content, int age) {
        System.out.println("ProxyTest sayHello begin");
        person.sayHello(content, age);
        System.out.println("ProxyTest sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgain, double time) {
        System.out.println("ProxyTest sayGoodBye begin");
        person.sayGoodBye(seeAgain, time);
        System.out.println("ProxyTest sayGoodBye end");
    }


    public static void main(String[] args) {
        // s为被代理对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问对象
        Student s = new Student();
        ProxyTest proxy = new ProxyTest(s);
        // 调用代理类对象的方法
        proxy.sayHello(" welcome to java", 20);
        System.out.println("********");
        // 调用代理类对象的方法
        proxy.sayGoodBye(true, 100);
    }
}
