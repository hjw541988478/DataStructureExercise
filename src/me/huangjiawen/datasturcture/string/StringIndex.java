package me.huangjiawen.datasturcture.string;

public class StringIndex {

	/**
	 * ����˼��ʵ��Ѱ��������s��pos���е�һ�γ����Ӵ�t��λ��
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
	 * �����next���飬��ŵ�i��λ��֮ǰ ǰ׺���ں�׺ ������� 
	 * 
	 * p[0..k-1] == p[j-k..j-1]
	 * ��P[k] == P[j]ʱ����next[j+1] == next[j] + 1
	 * ��P[k] != P[j]ʱ��k = next[k]
	 * 
	 * e.g:
	 * ���ذ棺 
	 *  a b c d a b c
	 * -1 0 0 0 0 1 2
	 * 
	 * �Ľ��棺
	 *  a b c d  a b c
	 * -1 0 0 0 -1 0 0
	 *  
	 *  ���ص��� ��s[i] != p[j]ʱ��jָ�����һ���ƶ�λ��
	 */
	public static int[] getPatternNextArray(String p) {
		int[] nextArry = new int[p.length()];
		// k ǰ׺ , j ��׺
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
	 * �����Ѿ�����ƥ�������Ч��Ϣ������iָ�벻���ݣ�ͨ���޸�jָ�룬��ģʽ���������ƶ�����Ч��λ��
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
