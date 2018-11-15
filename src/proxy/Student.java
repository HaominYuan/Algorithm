package proxy;

public class Student implements Person {


    @Override
    public void sayHello(String content, int age) {
        System.out.println("Student sayHello" + content + " " + age);

    }

    @Override
    public void sayGoodBye(boolean seeAgain, double time) {
        System.out.println("Student sayGoodBye " + time + " " + seeAgain);
    }
}
