/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        long numeratorLong = numerator < 0 ? -(long) numerator : numerator;
        long denominatorLong = denominator < 0 ? -(long) denominator : denominator;
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) {
            sb.append('-');
        }
        sb.append(numeratorLong / denominatorLong);
        numeratorLong = numeratorLong % denominatorLong * 10;
        if (numeratorLong == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (numeratorLong != 0) {
            Integer index = map.putIfAbsent(numeratorLong, sb.length());
            if (index == null) {
                sb.append(numeratorLong / denominatorLong);
                numeratorLong = numeratorLong % denominatorLong * 10;
            } else {
                sb.insert(index.intValue(), '(');
                sb.append(')');
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

