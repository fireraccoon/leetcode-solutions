// @algorithm @lc id=100318 lang=java 
// @title shu-zu-zhong-de-ni-xu-dui-lcof
// @test([7,5,6,4])=5
// @test([233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004])=69
package ____Offer_51__________LCOF_1;
import java.util.Arrays;
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] discreteNums = discrete(nums);
        BinaryIndexedTree tree = new BinaryIndexedTree(discreteNums.length);
        int ans = 0;
        for (int i = discreteNums.length - 1; i >= 0; i--) {
            ans += tree.query(discreteNums[i] - 1);
            tree.update(discreteNums[i]);
        }
        return ans;
    }
    private int[] discrete(int[] nums) {
        int[] tmp = new int[nums.length], ranks = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = Arrays.binarySearch(tmp, nums[i]);
        }
        return ranks;
    }
    private class BinaryIndexedTree {
        int[] tree;
        public BinaryIndexedTree(int n) {
            tree = new int[n + 1];
        }
        public void update(int index) {
            index++;
            while (index < tree.length) {
                tree[index]++;
                index += index & -index;
            }
        }
        public int query(int index) {
            index++;
            int ans = 0;
            while (index != 0) {
                ans += tree[index];
                index ^= index & -index;
            }
            return ans;
        }
    }
}