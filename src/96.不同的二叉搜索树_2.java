/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */
// @lc code=start
class Solution {
    public int numTrees(int n) {
        int ans = 1;
        int[] dp_0, dp_1 = new int[n];
        dp_1[0] = 1;
        for (int i = 1; i < n; i++) {
            dp_0 = dp_1.clone();
            dp_1[0] = ans;
            dp_1[1] = ans;
            ans += ans;
            for (int j = 2; j <= i; j++) {
                for (int k = j - 1; k < i; k++) {
                    if (k != j) {
                        dp_1[j] += dp_0[k];
                    }
                }
                ans += dp_1[j];
            }
            dp_1[i] = 1;
        }
        return ans;
    }
}
// @lc code=end

