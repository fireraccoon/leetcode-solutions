/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = m;
            while (left < right) {
                int middle = left + (right - left >> 1);
                if ((long) potions[middle] * spells[i] >= success) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            ans[i] = m - right;
        }
        return ans;
    }
}
// @lc code=end

