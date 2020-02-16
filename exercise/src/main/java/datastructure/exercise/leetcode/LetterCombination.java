package datastructure.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombination {

    private static final String[] table = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String nextNumberLetters = table[Character.getNumericValue(digits.charAt(i))];
            if (i == 0) {
                for (int j = 0; j < nextNumberLetters.length(); j++) {
                    res.add(String.valueOf(nextNumberLetters.charAt(j)));
                }
            } else {
                res = letterCombine(res, nextNumberLetters);
            }
        }
        return res;
    }

    private List<String> letterCombine(List<String> left, String right) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.length(); j++) {
                String combinedStr = left.get(i) + right.charAt(j);
                res.add(combinedStr);
            }
        }
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        letterCombine2(digits, res, new StringBuilder(), 0);
        return res;
    }

    private void letterCombine2(String digits, List<String> res, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String curNumberPanel = table[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < curNumberPanel.length(); i++) {
            sb.append(curNumberPanel.charAt(i));
            letterCombine2(digits, res, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombination demo = new LetterCombination();
        System.out.println(demo.letterCombinations(""));
        System.out.println(demo.letterCombinations2(""));
    }
}
