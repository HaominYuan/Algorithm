package leetcode;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(new MySolution().rotateString("abcde", "cdeab"));
    }

    static class MySolution {
        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            if (A.equals(B)) {
                return true;
            }
            int time = A.length() - 1;
            while (time-- != 0) {
                A = A.substring(1) + A.charAt(0);
                if (A.equals(B)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution {
        public boolean rotateString(String A, String B) {
            if(A == null && B == null) return true;
            if(A == null || B == null) return false;

            return A.length() == B.length() && (A + A).contains(B);
        }
    }

}
