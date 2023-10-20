/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    int[] tree, nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            update(i, val << 1);
            nums[i] = val;
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        index++;
        while (index < tree.length) {
            tree[index] += diff;
            index += index & -index;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        int ans = 0;
        index++;
        while (index != 0) {
            ans += tree[index];
            index ^= index & -index;
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

