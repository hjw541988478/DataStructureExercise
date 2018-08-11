package ds.exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    res.add(Arrays.asList(new Integer[]{nums[l], nums[r], nums[i]}));
                    while (l < r && nums[l++] == nums[l]) {
                    }
                    while (l < r && nums[r--] == nums[r]) {
                    }
                } else if (nums[l] + nums[r] > -nums[i]) {
                    while (l < r && nums[r--] == nums[r]) {
                    }
                } else {
                    while (l < r && nums[l++] == nums[l]) {
                    }
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    res.add(Arrays.asList(new Integer[]{nums[l], nums[r], nums[i]}));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
