/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int num = n;
        while (num % 4 == 0) {
            num /= 4;
        }
        if (num % 8 == 7) {
            return 4;
        }
        num = (int) Math.sqrt(n);
        if (num * num == n) {
            return 1;
        }
        for (int i = 1; i * i < n; i++) {
            num = n - i * i;
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                return 2;
            }
        }
        return 3;
    }
}
// @lc code=end

