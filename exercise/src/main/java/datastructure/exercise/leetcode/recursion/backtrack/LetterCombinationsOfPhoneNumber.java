package datastructure.exercise.leetcode.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits.length() == 0) {
            return res;
        }
        helper(res, "", digits);
        return res;
    }

    private static final HashMap<String, String> keypad = new HashMap();

    static {
        keypad.put("2", "abc");
        keypad.put("3", "def");
        keypad.put("4", "ghi");
        keypad.put("5", "jkl");
        keypad.put("6", "mno");
        keypad.put("7", "pqrs");
        keypad.put("8", "tuv");
        keypad.put("9", "wxyz");
    }

    public void helper(List<String> res, String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            res.add(combination);
            return;
        }
        String keyStr = keypad.get(nextDigits.substring(0, 1));
        for (int j = 0; j < keyStr.length(); j++) {
            helper(res, combination + keyStr.substring(j, j + 1), nextDigits.substring(1));
        }
    }
}
