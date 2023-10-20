/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String p = str1.substring(0, gcd(str1.length(), str2.length()));
        return isDivisor(str1, p) && isDivisor(str2, p) ? p : "";
    }
    boolean isDivisor(String s, String p) {
        int m = s.length(), n = p.length();
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != p.charAt(i % n)) {
                return false;
            }
        }
        return true;
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

