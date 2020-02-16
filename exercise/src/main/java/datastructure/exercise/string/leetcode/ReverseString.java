package datastructure.exercise.string.leetcode;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    // O(n)
    public void reverseStrByRecursion(char[] str) {
        int l = 0, r = str.length - 1;
        reverseStrCore(str, l, r);
    }

    public void reverseStrCore(char[] str, int l, int r) {
        if (l > r) {
            return;
        }
        char tmp = str[l];
        str[l] = str[r];
        str[r] = tmp;
        reverseStrCore(str, l + 1, r - 1);
    }

    // O(n)
    public void reverseStrByIteration(char[] str) {
        int l = 0, r = str.length - 1;
        while (l < r) {
            char tmp = str[l];
            str[l++] = str[r];
            str[r--] = tmp;
        }
    }
}
