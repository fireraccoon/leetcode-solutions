/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        char[] ans;
        String maxString, minString;
        if (a.length() > b.length()) {
            maxString = a;
            minString = b;
        } else {
            maxString = b;
            minString = a;
        }
        ans = new char[maxString.length() + 1];
        boolean carry = false;
        for (int i = maxString.length() - 1; i >= 0; i--) {
            int sum = (maxString.charAt(i) - '0') + (carry ? 1 : 0);
            if (i >= maxString.length() - minString.length()) {
                sum += (minString.charAt(i - (maxString.length() - minString.length())) - '0');
            }
            carry = sum > 1;
            ans[i + 1] = (char) (carry ? sum - 2 + '0' : sum + '0');
        }
        if (carry) {
            ans[0] = '1';
            return new String(ans);
        }
        return new String(Arrays.copyOfRange(ans, 1, ans.length));
    }
}
// @lc code=end

