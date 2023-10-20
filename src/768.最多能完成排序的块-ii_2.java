/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int[] sorted = getSortedArray(arr);
        Map<Integer, Integer> diffs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer diff = diffs.merge(arr[i], 1, Integer::sum);
            if (diff != null && diff == 0) {
                diffs.remove(arr[i]);
            }
            diff = diffs.merge(sorted[i], -1, Integer::sum);
            if (diff != null && diff == 0) {
                diffs.remove(sorted[i]);
            }
            if (diffs.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
    private int[] getSortedArray(int[] arr) {
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }
}
// @lc code=end

