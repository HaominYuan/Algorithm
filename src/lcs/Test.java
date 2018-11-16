package lcs;

public class Test {
    public static void main(String[] args) {
        CodeCheck codeCheck = new CodeCheck("src/lcs/a.cpp", "src/lcs/b.cpp");
        codeCheck.cal();
        System.out.println(codeCheck);
    }
}
