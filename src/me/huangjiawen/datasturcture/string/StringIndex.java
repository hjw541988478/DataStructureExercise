package me.huangjiawen.datasturcture.string;

public class StringIndex {

	/**
	 * 朴素思想实现寻找在主串s第pos后中第一次出现子串t的位置
	 * 
	 */
	public static int violentIndex(String s, String t, int pos) {
		if (pos < 0 || pos >= s.length()) {
			return -1;
		}
		int i = pos, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == t.length()) {
			return i - j;
		}
		return -1;
	}

	/**
	 * 计算出next数组，存放第i个位置之前 前缀等于后缀 的最长长度 
	 * 
	 * p[0..k-1] == p[j-k..j-1]
	 * 当P[k] == P[j]时，有next[j+1] == next[j] + 1
	 * 当P[k] != P[j]时，k = next[k]
	 * 
	 * e.g:
	 * 朴素版： 
	 *  a b c d a b c
	 * -1 0 0 0 0 1 2
	 * 
	 * 改进版：
	 *  a b c d  a b c
	 * -1 0 0 0 -1 0 0
	 *  
	 *  返回的是 当s[i] != p[j]时，j指针的下一步移动位置
	 */
	public static int[] getPatternNextArray(String p) {
		int[] nextArry = new int[p.length()];
		// k 前缀 , j 后缀
		int k = -1, j = 0;
		nextArry[0] = -1;
		while (j < p.length() - 1) {
			if (k == -1 || p.charAt(k) == p.charAt(j)) {
				k++;
				j++;
				if (p.charAt(j) == p.charAt(k)) {
					nextArry[j] = nextArry[k];
				} else {
					nextArry[j] = k;
				}
			} else {
				k = nextArry[k];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(p).append("\n");
		for(int nextVal : nextArry) {
			sb.append(nextVal);
		}
		System.out.println(sb.toString());
		return nextArry;
	}

	/**
	 * 利用已经部分匹配这个有效信息，保持i指针不回溯，通过修改j指针，让模式串尽量地移动到有效的位置
	 */
	public static int kmpIndex(String s, String p) {
		if (p.length() > s.length()) {
			return -1;
		}
		int[] nextArray = getPatternNextArray(p);
		if (nextArray.length > 0) {
			int i = 0, j = 0;
			while (i < s.length() && j < p.length()) {
				if (j == -1 || s.charAt(i) == p.charAt(j)) {
					i++;
					j++;
				} else {
					j = nextArray[j];
				}
			}
			if (j == p.length()) {
				return i - j;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(violentIndex("abcdababc", "abab", 0));
		getPatternNextArray("abcdabc");
		System.out.println(kmpIndex("abcdababc", "abab"));
	}

}
