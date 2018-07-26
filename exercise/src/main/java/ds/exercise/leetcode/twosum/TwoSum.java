package ds.exercise.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 1. Two Sum
     */
    public int[] twoSum(int[] nums, int target) {
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

    /**
     * 167. Two Sum II - Input array is sorted
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }

    /**
     * 2. Add Two Numbers
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = result;
        boolean ifGreaterThan10 = false;
        while (l1 != null || l2 != null) {
            int tmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (ifGreaterThan10) {
                tmp++;
            }
            ifGreaterThan10 = tmp >= 10;
            ListNode nextVal = new ListNode(tmp % 10);
            if (result != null) {
                result.next = nextVal;
                result = nextVal;
            } else {
                result = nextVal;
                head = result;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (ifGreaterThan10) {
            result.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
