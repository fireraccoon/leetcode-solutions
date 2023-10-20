/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的 K 对数字
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        k = (int) Math.min(k, (long) m * n);
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int i = 0; i < k && i < m; i++) {
            heap.offer(new Pair(i, 0, nums1[i], nums2[0]));
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0) {
            Pair pair = heap.poll();
            int idx1 = pair.idx1, idx2 = pair.idx2 + 1;
            ans.add(List.of(nums1[pair.idx1], nums2[pair.idx2]));
            if (idx2 < n) {
                heap.offer(new Pair(idx1, idx2, nums1[idx1], nums2[idx2]));
            }
        }
        return ans;
    }
    private class Pair implements Comparable<Pair> {
        public int idx1, idx2, sum;
        public Pair(int idx1, int idx2, int num1, int num2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = num1 + num2;
        }
        @Override
        public int compareTo(Pair o) {
            return sum - o.sum;
        }
    }
}
// @lc code=end

