package datastructure.exercise.leetcode;

/**
 * Created by Garvin on 2017/5/23.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
    private boolean isQueenSafe(int[] pos, int cur) {
        for (int i = 0; i < cur; i++) {
            if (Math.abs(i - cur) == Math.abs(pos[i] - pos[cur])
                    || pos[i] == pos[cur]) {
                return false;
            }
        }
        return true;
    }

    private boolean isProperSudokuNumber(char[][] board, int x, int y, char target) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == target) {
                return false;
            }
            if (board[i][y] == target) {
                return false;
            }
            // 第i个九宫格行列号
            int row = x / 3 * 3 + i / 3;
            int col = y / 3 * 3 + i % 3;
            if (board[row][col] == target) {
                return false;
            }
        }
        return true;
    }


    private boolean isIpAddressNumber(String s) {
        return s.startsWith("0") ? s.equals("0") : Integer.parseInt(s) <= 255
                && Integer.parseInt(s) >= 0;
    }

    private boolean isPalindromeString(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs4Subsets(List<List<Integer>> res, List<Integer> tmp,
                             int[] nums, int cur) {
        res.add(new ArrayList<Integer>(tmp));
        for (int i = cur; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs4Subsets(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void dfs4SubsetsWithDup(List<List<Integer>> res, List<Integer> tmp,
                                    int[] nums, int cur) {
        res.add(new ArrayList<Integer>(tmp));
        for (int i = cur; i < nums.length; i++) {
            // 跳过相邻重复的数字
            if (i > cur && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs4SubsetsWithDup(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void dfs4Permutation(List<List<Integer>> res, List<Integer> tmp,
                                 boolean[] visits, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visits[i]) {
                    visits[i] = true;
                    tmp.add(nums[i]);
                    dfs4Permutation(res, tmp, visits, nums);
                    tmp.remove(tmp.size() - 1);
                    visits[i] = false;
                }
            }
        }
    }

    private void dfs4PermutationUnique(List<List<Integer>> res,
                                       List<Integer> tmp, boolean[] visits, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visits[i] || i > 0 && nums[i] == nums[i - 1]
                        && visits[i - 1]) {
                    continue;
                }
                visits[i] = true;
                tmp.add(nums[i]);
                dfs4PermutationUnique(res, tmp, visits, nums);
                tmp.remove(tmp.size() - 1);
                visits[i] = false;
            }
        }
    }

    private void dfs4CombinationSum(List<List<Integer>> res,
                                    ArrayList<Integer> tmp, int[] candidates, int target, int curPos) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = curPos; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                dfs4CombinationSum(res, tmp, candidates,
                        target - candidates[i], i); // reuse current number
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private void dfs4CombinationSum2(List<List<Integer>> res,
                                     ArrayList<Integer> tmp, int[] candidates, int target, int curPos) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = curPos; i < candidates.length; i++) {
                if (i > curPos && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tmp.add(candidates[i]);
                dfs4CombinationSum2(res, tmp, candidates, target
                        - candidates[i], i + 1); // can not reuse current number
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private void dfs4GenerateParenthesis(List<String> res, String cur,
                                         int remaingLeft, int remaingRight) {
        if (remaingLeft == 0 && remaingRight == 0) {
            res.add(cur);
            return;
        }
        if (remaingLeft > 0) {
            dfs4GenerateParenthesis(res, cur + "(", remaingLeft - 1,
                    remaingRight);
        }
        if (remaingLeft < remaingRight) {
            dfs4GenerateParenthesis(res, cur + ")", remaingLeft,
                    remaingRight - 1);
        }
    }

    private void dfs4LetterCombinations(List<String> res, char[][] table,
                                        String tmp, String digits) {
        if (digits.length() == 0) {
            res.add(tmp);
            return;
        }
        for (int i = 0; i < table[digits.charAt(0) - '0' - 1].length; i++) {
            dfs4LetterCombinations(res, table, tmp
                    + table[digits.charAt(0) - '0' - 1][i], digits.substring(1));
        }
    }

    /**
     * 合法的地址由4段0~255内的数组成
     *
     * @param res
     * @param raw
     * @param cur
     * @param count
     */
    private void dfs4RestoreIpAddresses(List<String> res, String raw,
                                        String cur, int count) {
        if (count == 3) {
            if (isIpAddressNumber(raw)) {
                res.add(cur + raw);
            }
            return;
        }
        for (int i = 1; i < 4 && i < raw.length(); i++) {
            String tmp = raw.substring(0, i);
            if (isIpAddressNumber(tmp)) {
                dfs4RestoreIpAddresses(res, raw.substring(i), cur + tmp + ".",
                        count + 1);
            }
        }
    }


    private void dfs4PalindromePartition(List<List<String>> res, String s,
                                         List<String> tmp) {
        if (s.isEmpty()) {
            if (!tmp.isEmpty()) {
                res.add(new ArrayList<String>(tmp));
            }
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String tmpStr = s.substring(0, i);
            if (isPalindromeString(tmpStr)) {
                tmp.add(tmpStr);
                dfs4PalindromePartition(res, s.substring(i), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private void dfs4NQueens(List<List<String>> res, int n, int stepn, int[] pos) {
        if (stepn == n) {
            List<String> tmp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == pos[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
        } else {
            for (int i = 0; i < n; i++) {
                pos[stepn] = i;
                if (isQueenSafe(pos, stepn)) {
                    dfs4NQueens(res, n, stepn + 1, pos);
                }
            }
        }
    }

    private void dfs4TotalNQueens(int[] res, int[] loc, int cur, int n) {
        if (cur == n) {
            res[0]++;
        } else {
            for (int i = 0; i < n; i++) {
                loc[cur] = i;
                if (isQueenSafe(loc, cur)) {
                    dfs4TotalNQueens(res, loc, cur + 1, n);
                }
            }
        }
    }

    private void dfs4SurroundedRegions(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != 'o') {
            return;
        }
        board[row][col] = 'd';
        dfs4SurroundedRegions(board, row - 1, col);
        dfs4SurroundedRegions(board, row + 1, col);
        dfs4SurroundedRegions(board, row, col - 1);
        dfs4SurroundedRegions(board, row, col + 1);
    }

    private boolean dfs4WordSearch(char[][] board, char[] w, int x, int y,
                                   int index) {
        if (w.length == index) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
            return false;
        }
        if (w[index] != board[x][y]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs4WordSearch(board, w, x - 1, y, index + 1)
                || dfs4WordSearch(board, w, x + 1, y, index + 1)
                || dfs4WordSearch(board, w, x, y - 1, index + 1)
                || dfs4WordSearch(board, w, x, y + 1, index + 1);
        return exist;
    }

    private boolean dfs4SolveSudoku(char[][] board, List<Integer> emptyPos, int emptySize, int curSize) {
        if (curSize == emptySize) {
            return true;
        }
        int row = emptyPos.get(curSize) / 9;
        int col = emptyPos.get(curSize) % 9;
        for (int t = 1; t <= 9; t++) {
            if (isProperSudokuNumber(board, row, col, (char) (t + '0'))) {
                board[row][col] = (char) (t + '0');
                if (dfs4SolveSudoku(board, emptyPos, emptySize, curSize + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------

    /**
     * 允许重复的子集，含空子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs4Subsets(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    /**
     * 不允许重复的子集，含空子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs4SubsetsWithDup(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    /**
     * 求全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // optional
        Arrays.sort(nums);
        dfs4Permutation(res, new ArrayList<Integer>(),
                new boolean[nums.length], nums);
        return res;
    }

    /**
     * 求不重复的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs4PermutationUnique(res, new ArrayList<Integer>(),
                new boolean[nums.length], nums);
        return res;
    }

    /**
     * 求candidate组成的(可复用)集合的且和等于target可能的所有情况
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs4CombinationSum(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    /**
     * 求candidate组成的(不可重复)集合且和等于target可能的所有情况
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs4CombinationSum2(res, new ArrayList<Integer>(), candidates, target,
                0);
        return res;
    }

    /**
     * 求n对括号组成的所有可能的情况
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs4GenerateParenthesis(res, "", n, n);
        return res;
    }

    /**
     * 手机九宫格键盘的字母组合情况
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        char[][] table = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
                {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        dfs4LetterCombinations(res, table, "", digits);
        return res;
    }

    /**
     * IP地址字符串转换成合法的形式
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs4RestoreIpAddresses(res, s, "", 0);
        return res;
    }

    /**
     * 找出子集串为回文字符串的集合
     *
     * @param s
     * @return
     */
    public List<List<String>> palindromePartition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        dfs4PalindromePartition(res, s, new ArrayList<String>());
        return res;
    }

    /**
     * 计算被包围的O转化为X
     *
     * @param board
     */
    public void solveSurroundedRegions(char[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs4SurroundedRegions(board, i, 0);
            dfs4SurroundedRegions(board, i, col - 1);
        }
        for (int i = 1; i < col - 1; i++) {
            dfs4SurroundedRegions(board, 0, i);
            dfs4SurroundedRegions(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'd') {
                    board[i][j] = 'o';
                } else if (board[i][j] == 'o') {
                    board[i][j] = 'x';
                }
            }
        }
    }

    /**
     * 查找board二维字符数组中是否含有唯一的word字符串
     *
     * @param board
     * @param word
     * @return
     */
    public boolean wordSearchExist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs4WordSearch(board, w, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 打印N皇后的解
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] pos = new int[n];
        dfs4NQueens(res, n, 0, pos);
        return res;
    }

    /**
     * 求解N皇后解的个数
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        int[] res = new int[1];
        if (n <= 0) {
            return res[0];
        }
        int[] loc = new int[n];
        dfs4TotalNQueens(res, loc, 0, n);
        return res[0];
    }

    /**
     * https://leetcode.com/problems/sudoku-solver
     * <p>
     * 计算出完整的数独
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        List<Integer> emptyCharsPos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCharsPos.add(i * 9 + j);
                }
            }
        }
        int emptySize = emptyCharsPos.size();
        dfs4SolveSudoku(board, emptyCharsPos, emptySize, 0);
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        System.out.println("[1,2,3]的子集：");
        System.out.println(dfs.subsets(new int[]{1, 2, 3}));
        System.out.println("[1,2,2]的不重复的子集：");
        System.out.println(dfs.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println("[1,2,2]的全排列：");
        System.out.println(dfs.permute(new int[]{1, 2, 2}));
        System.out.println("[3,3,0,3]的不重复的全排列：");
        System.out.println(dfs.permuteUnique(new int[]{3, 3, 0, 3}));
        System.out.println("[2,3,6,7]能组成和为7的解集合：");
        System.out.println(dfs.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("[10,1,2,7,6,1,5]能组成和为8的解集合(不重复)：");
        System.out.println(dfs.combinationSum2(
                new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("3对括号组成的所有可能的情况：");
        System.out.println(dfs.generateParenthesis(3));
        System.out.println("23数字键盘组成的所有可能情况：");
        System.out.println(dfs.letterCombinations("23"));
        System.out.println("2552551134所有可能的IP地址：");
        System.out.println(dfs.restoreIpAddresses("2552551134"));
        System.out.println("aab所有可能的回文子串：");
        System.out.println(dfs.palindromePartition("aab"));
        System.out.println("[{'a','b','c'},{'d','e','f'}]是否包含{'a','d','e'}：");
        System.out.println("sol:"
                + dfs.wordSearchExist(new char[][]{{'a', 'b', 'c'},
                {'d', 'e', 'f'}}, "ade"));
        System.out.println("8皇后问题的解个数：");
        System.out.println(dfs.totalNQueens(8));
    }
}

