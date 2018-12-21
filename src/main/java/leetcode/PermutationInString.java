package leetcode;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(new MySolution().checkInclusion("ab", "eidbaooo"));
    }

    static class MySolution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            return func(s1.toCharArray(), s2, 0);
        }

        boolean func(char[] s1, String s2, int index) {
            if (index == s1.length) {
                return s2.contains(new String(s1));
            }

            for (int i = index; i < s1.length; i++) {
                swap(s1, i, index);
                if (func(s1, s2, index + 1)) {
                    return true;
                }
                swap(s1, i, index);
            }
            return false;
        }


        void swap(char[] s1, int i, int j) {
            char temp = s1[i];
            s1[i] = s1[j];
            s1[j] = temp;
        }
    }
}
