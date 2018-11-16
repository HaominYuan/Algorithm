package lcs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class PreProcess {
    private static String[] keyWords = new String[]{
            "for", "while", "do", "continue", "if", "else", "char", "int", "double", "float", "return"
            , "const"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/lcs/b.cpp"));
        String string;
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(PreProcess.converter(string));
        }
    }

    static String converter(String line) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '#') {
                result.append(line.substring(i));
                break;
            } else if ('/' == line.charAt(i)) {
                // 注释
                if (i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    result.append(line.substring(i));
                    break;
                }
            } else if (isLetter(line.charAt(i)) || line.charAt(i) == '_') {
                StringBuilder word = new StringBuilder(line.charAt(i) + "");
                int j = i + 1;
                while (j < line.length()) {
                    if (!isLetter(line.charAt(j)) && !isNumber(line.charAt(j)) && line.charAt(j) != '_') {
                        break;
                    }
                    word.append(line.charAt(j++));
                }
                if (!isKeyWord(word.toString())) {
                    if (!map.containsKey(word.toString())) {
                        map.put(word.toString(), index++);
                    }
                    String placeHolders = "青春期笨蛋不做兔女郎学姐的女主梦樱岛麻衣赛高";
                    result.append(placeHolders.charAt(map.get(word.toString())));
                } else {
                    result.append(word);
                }
                i = j - 1;
            } else if (line.charAt(i) == '"') {
                int j = i + 1;
                while (j < line.length()) {
                    if (line.charAt(j) == '"') {
                        break;
                    }
                    result.append(line.charAt(j++));
                }
                result.append("\"");
                i = j + 1;
            } else {
                result.append(line.charAt(i));
            }
        }
        return result.toString();
    }

    private static boolean isNumber(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private static boolean isLetter(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
    }

    private static boolean isKeyWord(String word) {
        for (String keyWord : keyWords) {
            if (keyWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

}
