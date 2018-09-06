package ds.exercise.leetcode;

public class StrStr {

    public int strStr(String haystack, String needle) {
        int res = -1;
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack != null && haystack.length() < needle.length()) {
            return -1;
        }
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) {
                    res = i;
                }
                if (j == needle.length() - 1) {
                    flag = true;
                    break;
                }
                i++;
                j++;
            } else {
                i = res != -1 ? res + 1 : i + 1;
                res = -1;
                j = 0;
            }
        }
        return flag ? res : -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi", "missa"));
    }
}
