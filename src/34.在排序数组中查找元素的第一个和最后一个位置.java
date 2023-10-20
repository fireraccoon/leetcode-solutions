


/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            binarySearch(nums, target, false),
            binarySearch(nums, target, true)
        };
    }
    int binarySearch(int[] nums, int target, boolean chooseMax) {
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (chooseMax) {
                    if (mid == nums.length - 1 || nums[mid+1] != target) {
                        ans = mid;
                        break;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (mid == 0 || nums[mid-1] != target) {
                        ans = mid;
                        break;
                    } else {
                        right = mid - 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

