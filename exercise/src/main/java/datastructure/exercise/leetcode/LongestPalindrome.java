package datastructure.exercise.leetcode;

public class LongestPalindrome {
    private int maxlen, start;

    private void judgePalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlen < k - j - 1) {
            start = j + 1;
            maxlen = k - j - 1;
        }
    }

    /**
     * 5. Longest Palindromic Substring
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            judgePalindrome(s, i, i);
            judgePalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxlen);
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("abcba"));
    }
}
