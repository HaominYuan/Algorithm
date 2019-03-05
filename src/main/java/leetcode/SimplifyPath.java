package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/Home"));
    }

    static class MySolution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == '/') {
                    if (stack.isEmpty() || !stack.peek().equals("/")) {
                        stack.push("/");
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder(path.charAt(i) + "");
                    while (i + 1 < path.length() && path.charAt(i + 1) != '/') {
                        i = i + 1;
                        stringBuilder.append(path.charAt(i));
                    }
                    if (stringBuilder.toString().equals("..")) {
                        if (stack.size() == 1) {
                            i = i + 1;
                            continue;
                        }
                        stack.pop();
                        stack.pop();
                        continue;
                    } else if (stringBuilder.toString().equals(".")) {
                        continue;
                    }
                    stack.push(stringBuilder.toString());
                }
            }
            StringBuilder simplePath = new StringBuilder();
            if (stack.size() != 1 && stack.peek().equals("/")) {
                stack.pop();
            }
            for (String s1 : stack) {
                simplePath.append(s1);
            }
            return simplePath.toString();
        }
    }

    static class Solution {
        public String simplifyPath(String path) {
            String[] arr = path.split("/");
            List<String> list = new ArrayList<>();
            list.add("");
            for (String s : arr) {
                if (s.length() == 0 || s.equals(".")) {
                    continue;
                }

                if (s.equals("..")) {
                    if (list.size() > 0 && !list.get(list.size() - 1).equals("")) {
                        list.remove(list.size() - 1);
                    }
                } else {
                    list.add(s);
                }
            }

            if (list.isEmpty()) {
                return "/";
            }

            StringBuilder simplyPath = new StringBuilder();
            for (String s : list) {
                simplyPath.append(s).append("/");
            }
            return simplyPath.length() > 1 ? simplyPath.substring(0, simplyPath.length() - 1) : simplyPath.toString();
        }
    }
}
