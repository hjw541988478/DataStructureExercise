package ds.exercise.leetcode.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TwoPointers {
    /**
     * 3. Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring1(String s) {
        int left = 0, right = 0;
        int size = s.length();
        ArrayList<Character> tmp = new ArrayList<Character>();
        int maxLen = 0;
        while (right != size) {
            char cur = s.charAt(right);
            if (right != 0) {
                if (tmp.contains(cur)) {
                    if (maxLen < tmp.size()) {
                        maxLen = tmp.size();
                    }
                    left++;
                    right = left;
                    tmp.clear();
                    continue;
                }
            }
            tmp.add(cur);
            right++;
        }
        return maxLen < tmp.size() ? tmp.size() : maxLen;
    }

    /**
     * 3. Longest Substring Without Repeating Characters(Best Solution)
     */
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TwoPointers demo = new TwoPointers();
        System.out.println(demo.lengthOfLongestSubstring2("abcbd"));
    }
}
