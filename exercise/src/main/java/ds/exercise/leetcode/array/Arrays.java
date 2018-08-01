package ds.exercise.leetcode.array;

public class Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0d;
        int[] sortedNums = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; ; ) {
            if (i >= nums1.length && j < nums2.length) {
                sortedNums[k++] = nums2[j++];
            } else if (i < nums1.length && j >= nums2.length) {
                sortedNums[k++] = nums1[i++];
            } else if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    sortedNums[k++] = nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    sortedNums[k++] = nums2[j++];
                } else {
                    sortedNums[k++] = nums1[i];
                    sortedNums[k++] = nums2[j];
                    i++;
                    j++;
                }
            } else {
                break;
            }
        }
        int sortedLen = sortedNums.length;
        if (sortedLen % 2 == 0) {
            median = 1.0d * (sortedNums[sortedLen / 2 - 1] + sortedNums[sortedLen / 2]) / 2.0d;
        } else {
            median = sortedNums[sortedLen / 2] * 1.0d;
        }
        return median;
    }

    public int getTopK(int[] m, int[] n, int k) {
        if (m.length > n.length) {
            return getTopK(n, m, k);
        }
        if (m.length == 0) {
            return n[k - 1];
        }
        if (k == 1) {
            return Math.min(m[0], n[0]);
        }
        int p = Math.min(m.length, k / 2);
        int q = k - p;
        if (m[p - 1] < n[q - 1]) {
            return getTopK(java.util.Arrays.copyOfRange(m, p, m.length), n, k - p);
        } else if (m[p - 1] > n[q - 1]) {
            return getTopK(m, java.util.Arrays.copyOfRange(n, q, n.length), k - q);
        } else {
            return m[p - 1];
        }
    }

    /**
     * 4. Median of Two Sorted Arrays
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 0) {
            return 0.5d * (getTopK(nums1, nums2, totalLen / 2 + 1) + getTopK(nums1, nums2, totalLen / 2));
        } else {
            return getTopK(nums1, nums2, totalLen / 2 + 1);
        }
    }

    public static void main(String[] args) {
        Arrays demo = new Arrays();
        System.out.println(demo.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(demo.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(demo.findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4}));
    }
}
