/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                if (i <= 0x7fff) {
                    for (int pow = i * i; pow < n; pow += i) {
                        isPrime[pow] = false;
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

