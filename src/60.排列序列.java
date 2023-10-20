/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        char[] ans = new char[n];
        int factorial = getFactorial(n - 1);
        int used = 0;
        k--;
        for (int i = 0; i < n; i++) {
            int nodeIndex = k / factorial;
            for (int j = 0;; j++) {
                if (Integer.bitCount(~used & ((1 << j + 1) - 1)) == nodeIndex + 1) {
                    nodeIndex = j;
                    break;
                }
            }
            ans[i] = (char)(nodeIndex + '1');
            k = k % factorial;
            factorial /= Math.max(n - i - 1, 1);
            used |= 1 << nodeIndex;
        }
        return new String(ans);
    }
    int getFactorial(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
// @lc code=end

