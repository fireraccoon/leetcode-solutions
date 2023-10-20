/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start

class Solution {
    static String[] b_table = {"I", "X", "C", "M"};
    static String[] m_table = {"V", "L", "D"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int factor = 1;
        while (num > 0) {
            sb.insert(0, itoRoman(num % 10, factor++));
            num /= 10;
        }
        return sb.toString();
    }
    public String itoRoman(int num, int factor) {
        switch(num) {
            case 0:
                return "";
            case 4:
                return b_table[factor-1] + m_table[factor-1];
            case 9:
                return b_table[factor-1] + b_table[factor];
            default:
                if (num < 5) {
                    return stringRepeat(b_table[factor-1], num);
                } else {
                    return m_table[factor-1] + stringRepeat(b_table[factor-1], num - 5);
                }
        }
    }
    public String stringRepeat(String s, int repeat) {
        StringBuilder sb = new StringBuilder(repeat);
        while (repeat-- > 0) {
            sb.append(s);
        }
        return sb.toString();
    }
}

// @lc code=end

