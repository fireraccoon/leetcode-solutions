/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = bitCount(i);
        }
        return ans;
    }
    int bitCount(int n) {
        n = (n & 0x55555555) + (n >>> 1 & 0x55555555);
        n = (n & 0x33333333) + (n >>> 2 & 0x33333333);
        n = (n & 0x0f0f0f0f) + (n >>> 4 & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + (n >>> 8 & 0x00ff00ff);
        n = (n & 0x0000ffff) + (n >>> 16 & 0x0000ffff);
        return n;
    }
}
// @lc code=end

