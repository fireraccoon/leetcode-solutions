/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] discreteNums = discrete(nums);
        BinaryIndexedTree tree = new BinaryIndexedTree(nums.length);
        List<Integer> ansList = Arrays.asList(new Integer[nums.length]);
        for (int i = nums.length - 1; i >= 0; i--) {
            ansList.set(i, tree.query(discreteNums[i] - 1));
            tree.update(discreteNums[i]);
        }
        return ansList;
    }
    private int[] discrete(int[] nums) {
        int[] ans = new int[nums.length], backup = new int[nums.length];
        System.arraycopy(nums, 0, backup, 0, nums.length);
        Arrays.sort(backup);
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Arrays.binarySearch(backup, nums[i]);
        }
        return ans;
    }
    private class BinaryIndexedTree {
        private int[] tree;
        public BinaryIndexedTree(int n) {
            this.tree = new int[n + 1];
        }
        public void update(int index) {
            index++;
            while (index < tree.length) {
                tree[index]++;
                index += index & -index;
            }
        }
        public int query(int index) {
            int ans = 0;
            index++;
            while (index != 0) {
                ans += tree[index];
                index ^= index & -index;
            }
            return ans;
        }
    }
}
// @lc code=end

