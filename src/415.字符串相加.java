/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int p1 = num1.length() - 1, p2 = num2.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            int sum = carry;
            if (p1 >= 0) {
                sum += num1.charAt(p1) - '0';
            }
            if (p2 >= 0) {
                sum += num2.charAt(p2) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

