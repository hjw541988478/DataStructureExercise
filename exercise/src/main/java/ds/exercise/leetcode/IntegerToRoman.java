package ds.exercise.leetcode;

import java.util.Stack;

/**
 * 12. Integer to Roman
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] digitOne = {"", "I", "X", "C", "M"};
        String[] digitFive = {"", "V", "L", "D"};
        String[] digitFoure = {"", "IV", "XL", "CD"};
        String[] digitNine = {"", "IX", "XC", "CM"};
        int curDigitCount = 0;
        Stack<String> stringStack = new Stack<>();
        while (num != 0) {
            curDigitCount++;
            int lastDigit = num % 10;
            if (lastDigit >= 5) {
                if (lastDigit == 9) {
                    stringStack.push(digitNine[curDigitCount]);
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append(digitFive[curDigitCount]);
                    int deltaDigit = lastDigit - 5;
                    while ((deltaDigit--) > 0) {
                        builder.append(digitOne[curDigitCount]);
                    }
                    stringStack.push(builder.toString());
                }
            } else {
                if (lastDigit == 4) {
                    stringStack.push(digitFoure[curDigitCount]);
                } else {
                    while ((lastDigit--) > 0) {
                        stringStack.push(digitOne[curDigitCount]);
                    }
                }
            }
            num /= 10;
        }
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.pop());
        }
        return sb.toString();
    }

    public String intToRoman2(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman toRoman = new IntegerToRoman();
        System.out.println(toRoman.intToRoman(3999));
    }
}
