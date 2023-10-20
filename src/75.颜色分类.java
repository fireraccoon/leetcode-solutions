/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int largeToExchange = 0, smallToExchange = nums.length - 1;
        int leftExplorer = 0;
        while (true) {
            while (leftExplorer < smallToExchange && nums[largeToExchange] == 0) {
                largeToExchange++;
                leftExplorer++;
            }
            while (leftExplorer < smallToExchange && nums[leftExplorer] == 1) {
                leftExplorer++;
            }
            while (leftExplorer < smallToExchange && nums[smallToExchange] == 2) {
                smallToExchange--;
            }
            if (largeToExchange == smallToExchange || (leftExplorer >= smallToExchange && nums[smallToExchange] != 0)) {
                break;
            }
            if (nums[leftExplorer] == 0) {
                swap(nums, leftExplorer, largeToExchange);
            } else {
                swap(nums, leftExplorer, smallToExchange);
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

