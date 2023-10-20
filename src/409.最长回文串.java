/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        int ans = 0;
        boolean hasOdd = false;
        for (int i = 0; i < map.length; i++) {
            ans += map[i] >> 1 << 1;
            hasOdd |= (map[i] & 1) == 1;
        }
        return ans + (hasOdd ? 1 : 0);
    }
}
// @lc code=end

