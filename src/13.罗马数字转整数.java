/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> fakeInt = new HashMap<>() {{
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        String p;
        int i = 0, result = 0;
        while (i < s.length()) {
            p = s.substring(i, Math.min(s.length(), i + 2));
            if (fakeInt.containsKey(p)) {
                result += fakeInt.get(p);
                i += 2;
            } else {
                result += getValue(s.charAt(i));
                i++;
            }
        }
        return result;
    }
    int getValue(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
// @lc code=end

