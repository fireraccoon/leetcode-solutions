/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] bits = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                bits[m-i+n-j-2] += x * (num2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] >= 10) {
                bits[i+1] += bits[i] / 10;
                bits[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bits[bits.length - 1] != 0 ? bits.length - 1 : bits.length - 2; i >= 0; i--) {
            sb.append(bits[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

