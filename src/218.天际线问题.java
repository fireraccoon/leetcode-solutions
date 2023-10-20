/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[] boundaries = new int[n * 2];
        for (int i = 0; i < n; i++) {
            boundaries[i * 2] = buildings[i][0];
            boundaries[i * 2 + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);

        PriorityQueue<RightAndHeight> queueForHeight = new PriorityQueue<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        for (int boundary : boundaries) {
            while (!queueForHeight.isEmpty() && queueForHeight.peek().right <= boundary) {
                queueForHeight.poll();
            }
            while (index < n && buildings[index][0] <= boundary) {
                if (buildings[index][1] > boundary) {
                    queueForHeight.offer(new RightAndHeight(buildings[index][1], buildings[index][2]));
                }
                index++;
            }

            int maxHeight = queueForHeight.isEmpty() ? 0 : queueForHeight.peek().height;
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != maxHeight) {
                ans.add(List.of(boundary, maxHeight));
            }
        }
        return ans;
    }
    private class RightAndHeight implements Comparable<RightAndHeight> {
        public int right;
        public int height;
        public RightAndHeight(int right, int height) {
            this.right = right;
            this.height = height;
        }
        @Override
        public int compareTo(RightAndHeight other) {
            return other.height - this.height;
        }
    }
}
// @lc code=end

