/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        for (boolean isSlowAdded = false; fast > 1; isSlowAdded = !isSlowAdded) {
            fast = getNextN(fast);
            if (isSlowAdded) {
                slow = getNextN(slow);
                if (slow == fast) {
                    break;
                }
            }
        }
        return fast == 1;
    }
    int getNextN(int n) {
        int nextN = 0;
        while (n > 0) {
            int base = n % 10;
            nextN += base * base;
            n /= 10;
        }
        return nextN;
    }
}
// @lc code=end

