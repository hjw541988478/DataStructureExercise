package datastructure.exercise.leetcode.recursion.divideandconquer;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return search(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }


    public boolean searchByIteration(int[][] m, int target) {
        int i = 0, j = m[0].length;
        while (j >= 0 && i < m[0].length) {
            if (m[i][j] == target) {
                return true;
            } else if (m[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * divide and conquer
     */
    public boolean search(int[][] m, int target, int p, int q, int i, int j) {
        if (p > i || q > j) {
            return false;
        }
        int midR = (p + i) / 2;
        int midC = (q + j) / 2;
        if (target == m[midR][midC]) {
            return true;
        } else if (target < m[midR][midC]) {
            return search(m, target, p, q, midR - 1, midC - 1)
                    || search(m, target, midR, q, i, midC - 1)
                    || search(m, target, p, midC, midR - 1, j);
        } else {
            return search(m, target, midR + 1, midC + 1, i, j)
                    || search(m, target, midR + 1, q, i, midC)
                    || search(m, target, p, midC + 1, midR, j);
        }

    }
}
