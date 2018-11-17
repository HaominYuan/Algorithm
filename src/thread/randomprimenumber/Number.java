package thread.randomprimenumber;

import java.util.HashSet;

class Number {
    private int number;
    private boolean flag;

    Number(int number) {
        this.number = number;
        flag = false;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    boolean isFlag() {
        return flag;
    }

    void setFlag(boolean flag) {
        this.flag = flag;
        hashSet.retainAll(new HashSet<>());
    }

    HashSet<Integer> hashSet = new HashSet<>();

}
