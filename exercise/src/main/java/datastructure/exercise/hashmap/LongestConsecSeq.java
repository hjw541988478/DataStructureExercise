package datastructure.exercise.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * <p>
 * O(n)
 */
public class LongestConsecSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> hashNum = new HashSet<>();
        for (int n : nums) {
            hashNum.add(n);
        }
        int max = 1;
        for (int n : nums) {
            if (!hashNum.contains(n - 1)) {
                int cur = 1;
                int tmp = n;
                while (hashNum.contains(tmp + 1)) {
                    tmp++;
                    cur++;
                }
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    // use hashmap to keep track of the sequence length and store that in the boundary points of the sequence
    public int longestConsecutiveHash(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                continue;
            }
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            max = Math.max(sum, max);
            map.put(n, sum);
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        return max;
    }
}
