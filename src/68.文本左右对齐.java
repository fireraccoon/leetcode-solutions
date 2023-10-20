/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int wordsLength = words[0].length(), start = 0;
        for (int end = 1; end < words.length; end++) {
            if (wordsLength + words[end].length() + (end - start) > maxWidth) {
                ans.add(wordsWithPadding(words, start, end - 1, maxWidth - wordsLength));
                wordsLength = words[end].length();
                start = end;
            } else {
                wordsLength += words[end].length();
            }
        }
        StringBuilder sb = new StringBuilder(maxWidth);
        sb.append(wordsWithPadding(words, start, words.length - 1, words.length - start - 1));
        sb.append(" ".repeat(maxWidth - wordsLength - (words.length - start - 1)));
        ans.add(sb.toString());
        return ans;
    }
    String wordsWithPadding(String[] words, int start, int end, int paddingLength) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(words[start]);
            sb.append(" ".repeat(paddingLength));
            return sb.toString();
        }
        int padding = paddingLength / (end - start);
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            sb.append(" ".repeat(padding));
            paddingLength -= padding;
            if (paddingLength + (1 - (end - i)) * padding > 0) {
                sb.append(' ');
                paddingLength--;
            }
        }
        sb.append(words[end]);
        return sb.toString();
    }
}
// @lc code=end

