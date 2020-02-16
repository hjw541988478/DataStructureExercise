package datastructure.exercise.leetcode.twopointers;

/**
 * 11. Container With Most Water
 */
public class MostWaterContainer {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            boolean leftSmaller = height[left] < height[right];
            int area = (leftSmaller ? height[left] : height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (leftSmaller) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MostWaterContainer mostWaterContainer = new MostWaterContainer();
        System.out.println(mostWaterContainer.maxArea(new int[]{1, 2, 4, 3}));
    }
}
