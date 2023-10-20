/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int batch = gcd(k, n);
        for (int i = 0; i < batch; i++) {
            int lastNum = nums[i];
            int j = i;
            do {
                j = (j + k) % n;
                int tmp = nums[j];
                nums[j] = lastNum;
                lastNum = tmp;
            } while (j != i);
        }
    }
    int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
// @lc code=end

