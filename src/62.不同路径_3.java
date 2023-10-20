/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// C^m-1_m+n-2 = (m+n-2)*...*n / (m-1)*...*1 ----- 都是m长

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // if (m > n) {
        //     int tmp = m;
        //     m = n;
        //     n = tmp;
        // }
        long ans = 1;
        for (int x = 1, y = n; x <= m - 1; x++, y++) {
            ans = ans * y / x;
        }
        return (int) ans;
    }
}
// @lc code=end

