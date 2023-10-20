/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

import java.util.List;

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                    + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
            triangle.get(i).set(i, triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i));
        }
        for (int i = 0; i < triangle.size(); i++) {
            ans = Math.min(ans, triangle.get(triangle.size() - 1).get(i));
        }
        return ans;
    }
}
// @lc code=end

