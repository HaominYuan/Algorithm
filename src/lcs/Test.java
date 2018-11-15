package lcs;

public class Test {
    public static void main(String[] args) {
        CodeCheck codeCheck = new CodeCheck("src/lcs/A0.c++.txt", "src/lcs/B0.c++.txt");
        codeCheck.cal();
        System.out.println(codeCheck);
    }
}
