package ds.exercise.leetcode;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (val == nums[i]) {
                len--;
                if (i != nums.length - 1) {
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                    }
                }
            }
        }
        return len;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
