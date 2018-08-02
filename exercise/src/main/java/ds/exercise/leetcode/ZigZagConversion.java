package ds.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6. ZigZag Conversion
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        int row = 0, col = 0, index = 0;
        int len = s.length();
        Map<Integer, List<Character>> resIndices = new HashMap<>(numRows);
        while (index < len) {
            List<Character> rowsIndex = resIndices.get(row);
            if (rowsIndex == null) {
                rowsIndex = new ArrayList<>();
                resIndices.put(row, rowsIndex);
            }
            rowsIndex.add(s.charAt(index++));
            if (col % (numRows - 1) == 0 && row != numRows - 1) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            List<Character> characters = resIndices.get(i);
            for (int j = 0; j < characters.size(); j++) {
                sb.append(characters.get(j));
            }
        }
        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        int incre = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                incre = 1;
            }
            if (index == numRows - 1) {
                incre = -1;
            }
            index += incre;
        }
        String re = "";
        for (int i = 0; i < sb.length; i++) {
            re += sb[i];
        }
        return re.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        //PAHNAPLSIIGYIR
        System.out.println(conversion.convert("PAYPALISHIRING", 3));
    }
}
