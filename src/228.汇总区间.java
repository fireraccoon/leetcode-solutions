/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        int begin = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || (long) nums[i] - nums[begin] > i - begin) {
                if (begin + 1 == i) {
                    ans.add(Integer.toString(nums[begin]));
                } else {
                    ans.add(new StringBuilder()
                        .append(nums[begin])
                        .append("->")
                        .append(nums[i - 1]).toString());
                }
                begin = i;
            }
        }
        return ans;
    }
}
// @lc code=end

