/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        Map<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = valueDiff + 1;
        for (int i = 0; i < n; i++) {
            int numBucket = getBucketId(nums[i], bucketSize);
            if (buckets.put(numBucket, nums[i]) != null
                || buckets.containsKey(numBucket - 1)
                    && Math.abs((long) buckets.get(numBucket - 1) - nums[i]) <= valueDiff
                || buckets.containsKey(numBucket + 1)
                    && Math.abs((long) buckets.get(numBucket + 1) - nums[i]) <= valueDiff) {
                return true;
            }
            if (i >= indexDiff) {
                buckets.remove(getBucketId(nums[i - indexDiff], bucketSize));
            }
        }
        return false;
    }
    int getBucketId(int value, int size) {
        return (value + 1_000_000_000) / size;
    }
}
// @lc code=end

