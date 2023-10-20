/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

import java.util.Set;

// @lc code=start
class Solution {
    private final static Set<Integer> sets = Set.of(4, 16, 37, 58, 89, 145, 42, 20);
    public boolean isHappy(int n) {
        for (int nextN = 0; n != 1 && !sets.contains(n); nextN = 0) {
            while (n > 0) {
                int base = n % 10;
                nextN += base * base;
                n /= 10;
            }
            n = nextN;
        }
        return n == 1;
    }
}
// @lc code=end

