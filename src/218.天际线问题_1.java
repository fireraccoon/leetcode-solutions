/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return partition(buildings, 0, buildings.length);
    }
    public List<List<Integer>> partition(int[][] buildings, int left, int right) {
        List<List<Integer>> ans = new ArrayList<>();
        if (left + 1 == right) {
            ans.add(List.of(buildings[left][0], buildings[left][2]));
            ans.add(List.of(buildings[left][1], 0));
            return ans;
        }
        int middle = (left + right) / 2;
        List<List<Integer>> lAns = partition(buildings, left, middle);
        List<List<Integer>> rAns = partition(buildings, middle, right);
        int l = 0, r = 0;
        int lHeight = 0, rHeight = 0;
        while (l < lAns.size() && r < rAns.size()) {
            int lX = lAns.get(l).get(0);
            int rX = rAns.get(r).get(0);
            int x;
            if (lX < rX) {
                x = lX;
                lHeight = lAns.get(l).get(1);
                l++;
            } else if (lX > rX) {
                x = rX;
                rHeight = rAns.get(r).get(1);
                r++;
            } else {
                x = lX;
                lHeight = lAns.get(l).get(1);
                rHeight = rAns.get(r).get(1);
                l++;
                r++;
            }
            int height = Math.max(lHeight, rHeight);
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != height) {
                ans.add(List.of(x, height));
            }
        }
        ans.addAll(lAns.subList(l, lAns.size()));
        ans.addAll(rAns.subList(r, rAns.size()));
        return ans;
    }
}
// @lc code=end

