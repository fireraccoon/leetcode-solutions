/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, window = 0; i <= n - 10; i++) {
            window = getHash(s, window, i, i + 10);
            Integer v = map.get(window);
            if (v == null) {
                map.put(window, 1);
            } else if (v == 1) {
                ans.add(s.substring(i, i + 10));
                map.put(window, -1);
            }
        }
        return ans;
    }
    int getHash(String s, int window, int begin, int end) {
        if (begin == 0) {
            for (int i = 0; i < end; i++) {
                window = (window << 2) + getPart(s.charAt(i));
            }
        } else {
            window = (window << 2 & 0x000fffff) + getPart(s.charAt(end - 1));
        }
        return window;
    }
    int getPart(char c) {
        return switch (c) {
            case 'A' -> 0b00;
            case 'C' -> 0b01;
            case 'G' -> 0b10;
            case 'T' -> 0b11;
            default -> -1;
        };
    }
}
// @lc code=end

