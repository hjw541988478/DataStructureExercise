package datastructure.exercise.leetcode.recursion.divideandconquer;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] nums = {7, 3, 5, 2, 1, 4, 6, 7, 8};
        System.out.println("before sorting:" + Arrays.toString(nums));
        sort.merge(nums);
        System.out.println("after sorting:" + Arrays.toString(nums));
    }

    public void merge(int[] nums) {
//        topDownMergeSort(nums, 0 , nums.length-1);
        bottomUpMergeSort(nums);
    }

    /**
     * sort array for top-down by using divide and conquer in ascending order
     */
    private void topDownMergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        topDownMergeSort(nums, l, m);
        topDownMergeSort(nums, m + 1, r);
        mergeTwoParts(nums, l, m, r);
    }

    /**
     * sort array for bottom-up way by using iteration in ascending order
     *
     * @param nums
     */
    private void bottomUpMergeSort(int[] nums) {
        for (int width = 1; width < nums.length; width *= 2) {
            for (int i = 0; i < nums.length - width; i += width * 2) {
                int m = i + width - 1;
                int r = Math.min(nums.length - 1, i + 2 * width - 1);
                mergeTwoParts(nums, i, m, r);
            }
        }
    }

    private void mergeTwoParts(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m || j <= r) {
            if (i > m || j <= r && nums[j] < nums[i]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, tmp.length);
    }
}
