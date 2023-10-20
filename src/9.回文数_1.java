/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> array = new ArrayList<>();
        while (true) {
            if (x == 0) {
                break;
            }
            array.add(x % 10);
            x /= 10;
        }
        int size = array.size();
        for (int i = 0; i < size / 2; i++) {
            if (!array.get(i).equals(array.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

