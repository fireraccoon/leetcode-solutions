/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftPolicy = new int[n];
        leftPolicy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftPolicy[i] = leftPolicy[i - 1] + 1;
            } else {
                leftPolicy[i] = 1;
            }
        }
        int ans = leftPolicy[n - 1], rightPolicy = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightPolicy = rightPolicy + 1;
            } else {
                rightPolicy = 1;
            }
            ans += Math.max(leftPolicy[i], rightPolicy);
        }
        return ans;
    }
}
// @lc code=end

