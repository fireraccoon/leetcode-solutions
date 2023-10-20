/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(), k, n, 1);
        return ans;
    }
    void dfs(List<List<Integer>> ans, Deque<Integer> node, int k, int n, int begin) {
        int extraSpace = k - node.size();
        if (extraSpace == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(node));
            }
            return;
        } else if (S_n(begin, Math.min(begin + extraSpace - 1, 9), 1) > n
            || S_n(Math.max(10 - extraSpace, 1), 9, 1) < n) {
            return;
        }
        for (int i = begin; i <= 9; i++) {
            node.push(i);
            dfs(ans, node, k, n - i, i + 1);
            node.pop();
        }
    }
    int S_n(int a_1, int a_n, int d) {
        int n = (a_n - a_1) / d + 1;
        return (a_1 + a_n) * n / 2;
    }
}
// @lc code=end

