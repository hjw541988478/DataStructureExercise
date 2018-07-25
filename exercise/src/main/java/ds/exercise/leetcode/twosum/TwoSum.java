package ds.exercise.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * @param nums   [2, 7, 11, 15]
     * @param target 9
     * @return 0, 1
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = posMap.get(target - nums[i]);
                return res;
            }
            posMap.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
