package datastructure.exercise.leetcode.recursion;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibNumber {
    HashMap<Integer, Integer> cache = new HashMap();

    public int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        if (N < 2) {
            return N;
        } else {
            int res = fib(N - 1) + fib(N - 2);
            cache.put(N, res);
            return res;
        }
    }
}