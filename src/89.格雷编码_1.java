/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, 0, 0, 0, n);
        return ans;
    }
    void dfs(List<Integer> ans, int node, int isRightSubtree, int deepth, int n) {
        if (deepth == n) {
            ans.add(node);
            return;
        }
        dfs(ans, (node << 1) | isRightSubtree, 0, deepth + 1, n);
        dfs(ans, (node << 1) | isRightSubtree ^ 1, 1, deepth + 1, n);
    }
}
// @lc code=end

