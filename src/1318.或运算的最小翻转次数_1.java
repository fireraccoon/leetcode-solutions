/*
 * @lc app=leetcode.cn id=1318 lang=java
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int bitA = (a >>> i) & 1;
            int bitB = (b >>> i) & 1;
            int bitC = (c >>> i) & 1;
            if (bitC == 0) {
                ans += bitA + bitB;
            } else if (bitA == 0 && bitB == 0) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

