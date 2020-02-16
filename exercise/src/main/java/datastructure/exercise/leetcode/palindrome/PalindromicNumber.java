package datastructure.exercise.leetcode.palindrome;



public class PalindromicNumber {

    /**
     * https://leetcode.com/problems/palindrome-number
     */
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

    public static boolean isLetterOrNumber(char ch) {
        return (ch >= 'a' && ch <= 'z')
                || isUpperLetter(ch)
                || (ch >= '0' && ch <= '9');
    }

    public static boolean isUpperLetter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isEqual(char chA, char chB) {
        if (isUpperLetter(chA)) {
            chA += 32;
        }
        if (isUpperLetter(chB)) {
            chB += 32;
        }
        return chA == chB;
    }

    /**
     * https://leetcode.com/problems/valid-palindrome
     *
     * @param s
     * @return
     */
    public static boolean isPalindromicNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        char[] sArr = s.toLowerCase().trim().toCharArray();
        int size = sArr.length;
        int start = 0, end = size - 1;
        while (start < end) {
            if (!isLetterOrNumber(sArr[start])) {
                start++;
                continue;
            }
            if (!isLetterOrNumber(sArr[end])) {
                end--;
                continue;
            }
            if (isLetterOrNumber(sArr[start])
                    && isLetterOrNumber(sArr[end])) {
                if (!isEqual(sArr[start], sArr[end])) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromicNumber("  a "));
        System.out.println(isPalindromicNumber("a     "));
        System.out.println(isPalindromicNumber("     "));
        System.out.println(isPalindromicNumber("abcba"));
        System.out.println(isPalindromicNumber("A man, a plan, a canal: Panama"));
        System.out.print(isPalindromicNumber("race a car"));

    }
}
