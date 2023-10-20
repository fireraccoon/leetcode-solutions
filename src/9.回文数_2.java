/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start

class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        } else if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reverse = 0;
        while (true) {
            if (reverse > x) {
                break;
            } else if (reverse == x) {
                return true;
            }
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (reverse / 10 == x) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

