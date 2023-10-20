/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketVolume = Math.max(1, (max - min) / (n - 1));
        int bucketSize = (max - min) / bucketVolume + 1;
        int[][] buckets = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int id = (nums[i] - min) / bucketVolume;
            buckets[id][0] = Math.min(buckets[id][0], nums[i]);
            buckets[id][1] = Math.max(buckets[id][1], nums[i]);
        }

        int ans = 0;
        for (int i = 0, prev = -1; i < bucketSize; i++) {
            if (buckets[i][0] != Integer.MAX_VALUE) {
                if (prev != -1) {
                    ans = Math.max(ans, buckets[i][0] - buckets[prev][1]);
                }
                prev = i;
            }
        }
        return ans;
    }
}
// @lc code=end

