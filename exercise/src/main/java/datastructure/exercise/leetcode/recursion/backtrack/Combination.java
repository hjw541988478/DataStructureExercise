package datastructure.exercise.leetcode.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList(2), 1, n, k);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int index, int n, int k) {
        if (0 == k) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int i = index; i <= n - k + 1; i++) {
            tmp.add(i);
            backtrack(res, tmp, i + 1, n, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
