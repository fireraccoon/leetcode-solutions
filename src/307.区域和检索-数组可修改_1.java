/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    int[] nums, tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length];
        buildTree(0, nums.length - 1);
    }

    public void update(int index, int val) {
        nums[index] = val;
        updateTree(index, 0, tree.length - 1);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left) + nums[left];
    }

    private int prefixSum(int target) {
        return prefixSum(target, 0, tree.length - 1);
    }

    private int prefixSum(int target, int start, int end) {
        int root = start + end >> 1;
        int sum = tree[root] - node(root + 1, end);
        while (root != target) {
            if (target < root) {
                end = root - 1;
                sum -= nums[root];
                root = start + end >> 1;
                sum -= node(root + 1, end);
            } else {
                start = root + 1;
                root = start + end >> 1;
                sum += node(start, root - 1) + nums[root];
            }
        }
        return sum;
    }

    private int updateTree(int target, int start, int end) {
        int root = start + end >> 1;
        if (target == root) {
            tree[root] = nums[root] + node(start, root - 1) + node(root + 1, end);
        } else if (target < root) {
            tree[root] = nums[root] + updateTree(target, start, root - 1) + node(root + 1, end);
        } else {
            tree[root] = nums[root] + node(start, root - 1) + updateTree(target, root + 1, end);
        }
        return tree[root];
    }

    private int node(int start, int end) {
        return start > end ? 0 : tree[start + end >> 1];
    }

    private int buildTree(int start, int end) {
        if (start == end) {
            tree[start] = nums[start];
            return tree[start];
        } else if (start > end) {
            return 0;
        }
        int root = start + end >> 1;
        tree[root] = nums[root] + buildTree(start, root - 1) + buildTree(root + 1, end);
        return tree[root];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

