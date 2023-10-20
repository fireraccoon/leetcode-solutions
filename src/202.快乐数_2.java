/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        while (set.add(n)) {
            int nextN = 0;
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

