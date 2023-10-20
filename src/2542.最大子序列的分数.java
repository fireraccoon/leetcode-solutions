/*
 * @lc app=leetcode.cn id=2542 lang=java
 *
 * [2542] 最大子序列的分数
 */

import java.util.Arrays;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);

        long sum = 0L;
        long ans = 0L;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            sum += nums1[index];
            heap.offer(nums1[index]);
            if (heap.size() == k) {
                ans = Math.max(sum * nums2[index], ans);
                sum -= heap.poll();
            }
        }
        return ans;
    }
}
// @lc code=end

