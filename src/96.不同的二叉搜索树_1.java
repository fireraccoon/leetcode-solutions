/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * (4 * i + 2) / (i + 2);
        }
        return (int) ans;
    }
}
// @lc code=end

