/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        for (int i = Math.min(m, n); i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                String p = str1.substring(0, i);
                if (isDivisor(str1, p) && isDivisor(str2, p)) {
                    return p;
                }
            }
        }
        return "";
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
}
// @lc code=end

