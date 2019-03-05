package leetcode;

/**
 * @ProjectName: leetcode
 * @Description: java类作用描述
 * @Author: Tst
 * @CreateDate: 2018/8/12 下午8:49
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "baada";
        s1 = "anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjj" +
                "ovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcva" +
                "scgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthp" +
                "yyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusg" +
                "oobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlp" +
                "lnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuiz" +
                "qynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmq" +
                "likrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
        String s2 = new StringBuilder(s1).reverse().toString();
        int index = s1.length() - 1;
        int max = Integer.MIN_VALUE;
        int[][] ints = new int[s1.length() + 1][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new int[s2.length() + 1];
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    ints[i + 1][j + 1] = ints[i][j] + 1;
                    if (ints[i + 1][j + 1] > max) {
                        max = ints[i + 1][j + 1];
                        index = i;
                    }
                }
            }
        }
        System.out.println(s1.substring(index - max + 1, index + 1));
    }



}
