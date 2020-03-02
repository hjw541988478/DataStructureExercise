package datastructure.exercise.leetcode.recursion.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {

    /**
     * 打印N皇后的解
     * https://leetcode.com/problems/n-queens
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList();
        backtrack(res, n, new LinkedList());
        return res;
    }

    /**
     * 求解N皇后解的个数
     * https://leetcode.com/problems/n-queens-ii/
     */
    public int totalNQueens(int n) {
        return backtrackTotal(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n], 0);
    }

    /**
     * d2: sub-diagonal value always equal to row - col + n
     * d1: main-diagonal values always equal to col + row
     * cols: same columns
     */
    public int backtrackTotal(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2, int count) {
        if (row == n) {
            count++;
        } else {
            for (int col = 0; col < n; col++) {
                int d1t = col + row;
                int d2t = row - col + n;
                if (cols[col] || d1[d1t] || d2[d2t]) {
                    continue;
                }
                cols[col] = true;
                d1[d1t] = true;
                d2[d2t] = true;
                count = backtrackTotal(row + 1, n, cols, d1, d2, count);
                cols[col] = false;
                d1[d1t] = false;
                d2[d2t] = false;
            }
        }
        return count;
    }

    /**
     * 列之差与行之差相等 || 同一列
     */
    public boolean isQueenSafe(List<Integer> curQs, int curCol) {
        int curRow = curQs.size();
        for (int row = 0; row < curRow; row++) {
            if (curQs.get(row) == curCol || Math.abs(row - curRow) == Math.abs(curCol - curQs.get(row))) {
                return false;
            }
        }
        return true;
    }

    public void backtrack(List<List<String>> res, int n, List<Integer> curQs) {
        if (curQs.size() == n) {
            List<String> tmp = new LinkedList();
            char[] s = new char[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(s, '.');
                s[curQs.get(i)] = 'Q';
                tmp.add(new String(s));
            }
            res.add(tmp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isQueenSafe(curQs, col)) {
                curQs.add(col);
                backtrack(res, n, curQs);
                curQs.remove(curQs.size() - 1);
            }
        }
    }

}
