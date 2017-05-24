package ds.exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 024 2017/5/24.
 */

public class GenerizeAbbreviations {

    public List<String> generateAbbreviations(String word) {

        List<String> result = new ArrayList<String>();

        backtrack(result, word, 0, "", 0);

        return result;

    }

    void backtrack(List result, String word, int position, String current, int count) {

        if (position == word.length()) {

            if (count > 0) {

                current += count;

            }
            System.out.println(String.format("%d_%s", count, current));
            result.add(current);

        } else {

            backtrack(result, word, position + 1, current, count + 1);
            backtrack(result, word, position + 1, current + (count > 0 ? count : "") + word.charAt(position), 0);

        }

    }

    public static void main(String[] args) {
        new GenerizeAbbreviations().generateAbbreviations("word");
    }


}
