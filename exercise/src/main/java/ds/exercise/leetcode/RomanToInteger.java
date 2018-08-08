package ds.exercise.leetcode;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        int res = 0;
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (index < s.length()) {
            if ('M' == s.charAt(index)) {
                res += 1000;
            } else if ('C' == s.charAt(index)) {
                if (index + 1 < s.length()) {
                    if ('M' == s.charAt(index + 1)) {
                        res += 900;
                        index++;
                    } else if ('D' == s.charAt(index + 1)) {
                        res += 400;
                        index++;
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
            } else if ('I' == s.charAt(index)) {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'X') {
                    res += 9;
                    index++;
                } else if (index + 1 < s.length() && s.charAt(index + 1) == 'V') {
                    res += 4;
                    index++;
                } else {
                    res += 1;
                }
            } else if ('X' == s.charAt(index)) {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'C') {
                    res += 90;
                    index++;
                } else if (index + 1 < s.length() && s.charAt(index + 1) == 'L') {
                    res += 40;
                    index++;
                } else {
                    res += 10;
                }
            } else if ('L' == s.charAt(index)) {
                res += 50;
            } else if ('V' == s.charAt(index)) {
                res += 5;
            } else if ('D' == s.charAt(index)) {
                res += 500;
            }
            index++;
        }
        return res;
    }

    public int romanToInt2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("IX"));
    }
}
