package datastructure.exercise.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * O(n)
 * <p>
 * at least 3 solutions
 * No.1 is brute force by iterating twice
 * No.2 is use hashmap by passing twice
 * NO.3 is just shown below
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
