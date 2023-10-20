/*
 * @lc app=leetcode.cn id=502 lang=java
 *
 * [502] IPO
 */

import java.util.Arrays;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        sort(profits, capital);
        int pointer = 0;
        while (k-- > 0) {
            while (pointer < n && w >= capital[pointer]) {
                heap.offer(profits[pointer++]);
            }
            if (heap.isEmpty()) {
                break;
            }
            w += heap.poll();
        }
        return w;
    }
    void sort(int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(profits[i], capital[i]);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < n; i++) {
            profits[i] = pairs[i].profit;
            capital[i] = pairs[i].capital;
        }
    }
    private class Pair implements Comparable<Pair> {
        public int profit;
        public int capital;
        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        @Override
        public int compareTo(Pair x) {
            return capital - x.capital;
        }
    }
}
// @lc code=end

