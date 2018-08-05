package ds.exercise.leetcode;

/**
 * 8. String to Integer (atoi)
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int res = 0;
        int index = 0;
        boolean valid = true, positive = false, negative = false, used = false, digited = false;
        while (index < str.length() && valid) {
            char tmp = str.charAt(index++);
            if (tmp == '-' || tmp == '+' || (tmp >= '0' && tmp <= '9')) {
                used = true;
                if (tmp == '-') {
                    if (negative || positive || digited) {
                        valid = false;
                    } else {
                        negative = true;
                    }
                } else if (tmp == '+') {
                    if (positive || negative || digited) {
                        valid = false;
                    } else {
                        positive = true;
                    }
                } else {
                    digited = true;
                    int intTmp = tmp - '0';
                    if (!negative && (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && intTmp > 7))) {
                        return Integer.MAX_VALUE;
                    } else if (negative && (Integer.MIN_VALUE / 10 > -1 * res || (Integer.MIN_VALUE / 10 == -1 * res && -1 * intTmp < -8))) {
                        return Integer.MIN_VALUE;
                    }
                    res = res * 10 + intTmp;
                }
            } else {
                if (tmp == ' ' && !used) {
                    continue;
                }
                break;
            }
        }
        return !negative ? res : -1 * res;
    }

    public int myAtoi2(String str) {
        int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i >= str.length()) return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == -1) return INT_MIN;
                else return INT_MAX;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }

        return base * sign;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("0-1"));
    }
}
