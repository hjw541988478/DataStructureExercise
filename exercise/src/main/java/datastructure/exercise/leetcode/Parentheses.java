package datastructure.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character topChar = stack.isEmpty() ? null : stack.peek();
            char curChar = s.charAt(i);
            if (topChar != null) {
                if (topChar.charValue() == '(') {
                    if (curChar == ')') {
                        stack.pop();
                        continue;
                    }
                } else if (topChar.charValue() == '{') {
                    if (curChar == '}') {
                        stack.pop();
                        continue;
                    }
                } else if (topChar.charValue() == '[') {
                    if (curChar == ']') {
                        stack.pop();
                        continue;
                    }
                }
            }
            stack.push(Character.valueOf(curChar));
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        genParenthesis(res, new StringBuilder(), 0, n * 2);
        return res;
    }

    private void genParenthesis(List<String> res, StringBuilder sb, int index, int n) {
        if (sb.length() == n) {
            if (isValid2(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        genParenthesis(res, sb, index + 1, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        genParenthesis(res, sb, index + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }


    public void dfs(List<String> res, String cur, int l, int r) {
        System.out.println("res:" + cur);
        if (l == 0 && r == 0) {
            res.add(cur);
            return;
        }
        if (l > 0) {
            dfs(res, cur + "(", l - 1, r);
        }
        if (l < r) {
            dfs(res, cur + ")", l, r - 1);
        }

    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(res, "", n, n);
        return res;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Parentheses demo = new Parentheses();
        System.out.println(demo.isValid("{}{}"));
        long start = System.currentTimeMillis();
        System.out.println(demo.generateParenthesis(3));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        System.out.println(demo.generateParenthesis2(3));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
