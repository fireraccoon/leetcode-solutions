/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int ans = 1;
        int policy = 1, increaseLength = 1, decreaseLength = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                decreaseLength = 0;
                policy = ratings[i] == ratings[i - 1] ? 1 : policy + 1;
                ans += policy;
                increaseLength = policy;
            } else {
                decreaseLength++;
                ans += decreaseLength;
                if (decreaseLength >= increaseLength) {
                    ans++;
                }
                policy = 1;
            }
        }
        return ans;
    }
}
// @lc code=end

