/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        List<Integer> primes = new LinkedList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int prime : primes) {
                int nextComposite = i * prime;
                if (nextComposite >= n) {
                    break;
                }
                isPrime[nextComposite] = false;
                if (i % prime == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
// @lc code=end

