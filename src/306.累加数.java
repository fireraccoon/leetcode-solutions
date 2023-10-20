/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    private final static long NULL = -1;
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        long[][] nums = new long[n][n];
        for (int i = 0; i < n; i++) {
            nums[i][i] = num.charAt(i) - '0';
            for (int j = i + 1; j < n; j++) {
                nums[i][j] = nums[i][j - 1] * 10 - '0' + num.charAt(j);
            }
        }
        return dfs(nums, 0, NULL, NULL, 0);
    }
    boolean dfs(long[][] nums, int begin, long a, long b, int count) {
        if (begin == nums.length) {
            return count >= 3;
        }
        boolean ans = false;
        long sum = a + b;
        int maxLength = Math.min(nums.length / 2 + begin, nums.length);
        count++;
        for (int i = begin; i < maxLength && !ans; i++) {
            if (a == NULL) {
                ans = dfs(nums, i + 1, nums[begin][i], b, count);
            } else if (b == NULL) {
                ans = dfs(nums, i + 1, a, nums[begin][i], count);
            } else if (sum >= nums[begin][i]) {
                ans = sum == nums[begin][i] && dfs(nums, i + 1, b, nums[begin][i], count);
            } else {
                break;
            }
            if (nums[begin][begin] == 0) {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

