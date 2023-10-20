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
        this.tree = new int[nums.length * 4];
        buildTree(0, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        int left = 0, right = nums.length - 1, node = 0;
        while (left != right) {
            tree[node] += diff;
            int middle = left + (right - left >> 1);
            if (index <= middle) {
                right = middle;
                node = node * 2 + 1;
            } else {
                left = middle + 1;
                node = node * 2 + 2;
            }
        }
        tree[node] += diff;
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, 0, nums.length - 1);
    }

    private int sumRange(int leftTarget, int rightTarget, int index, int left, int right) {
        if (leftTarget == left && rightTarget == right) {
            return tree[index];
        }
        int middle = left + (right - left >> 1);
        if (rightTarget <= middle) {
            return sumRange(leftTarget, rightTarget, index * 2 + 1, left, middle);
        } else if (leftTarget > middle) {
            return sumRange(leftTarget, rightTarget, index * 2 + 2, middle + 1, right);
        }
        return sumRange(leftTarget, middle, index * 2 + 1, left, middle)
            + sumRange(middle + 1, rightTarget, index * 2 + 2, middle + 1, right);
    }

    private void buildTree(int index, int left, int right) {
        if (left == right) {
            tree[index] = nums[left];
            return;
        }
        int middle = left + (right - left >> 1);
        buildTree(index * 2 + 1, left, middle);
        buildTree(index * 2 + 2, middle + 1, right);
        tree[index] = tree[index * 2 + 1] + tree[index * 2 + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

