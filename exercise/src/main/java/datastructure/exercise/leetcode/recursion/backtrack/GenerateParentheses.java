package datastructure.exercise.leetcode.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, 0, 0, n, new StringBuilder());
        return res;
    }

    public void backtrack(List<String> res, int left, int right, int n, StringBuilder tmp) {
        if (n * 2 == tmp.length()) {
            res.add(tmp.toString());
            return;
        }
        if (left < n) {
            tmp.append("(");
            backtrack(res, left + 1, right, n, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right < left) {
            tmp.append(")");
            backtrack(res, left, right + 1, n, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
