/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    int gcd(int x, int y) {
        while (x % y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return y;
    }
}
// @lc code=end

