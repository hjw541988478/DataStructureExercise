package ds.exercise.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number
 */

public class PalindromicNumber {

    public static boolean isPalindromicNumber(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9 && x >= 0) {
            return true;
        }
        int size = 0, reverseNum = x, tmp, first, last;
        while (reverseNum != 0) {
            size++;
            reverseNum /= 10;
        }
        tmp = size;
        first = (int) (x / (Math.pow(10, (tmp - 1))));
        last = x % 10;
        if (size == 2 || size == 3) {
            return first == last;
        } else {
            while (tmp > size / 2) {
                if (first != last) {
                    return false;
                }
                tmp--;
                first = (int) (x / Math.pow(10, tmp - 1) % 10);
                last = (int) (x / Math.pow(10, (size - tmp)) % 10);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindromicNumber(-2147447412));
    }
}
