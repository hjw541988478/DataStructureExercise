package datastructure.exercise.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 7. Reverse Integer
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean negative = x < 0;
        if (negative) {
            x = Math.abs(x);
        }
        boolean firstZero = true;
        List<Integer> list = new LinkedList<>();
        while (x > 0) {
            int data = x % 10;
            if (firstZero) {
                firstZero = data == 0;
            }
            if (!firstZero) {
                list.add(data);
            }
            x /= 10;
        }
        int res = 0, size = list.size();
        for (int i = 0; i < size; i++) {
            if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && list.get(i) > 7) {
                return 0;
            }
            res = res * 10 + list.get(i);
        }
        return negative ? -1 * res : res;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534222123));
    }
}
