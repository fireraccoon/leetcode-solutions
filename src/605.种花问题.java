/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean added = false;
        for (int i = 0; i < flowerbed.length - 1 && n > 0; i++) {
            if (!added && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                added = true;
            } else {
                added = flowerbed[i] == 1;
            }
        }
        if (!added && flowerbed[flowerbed.length - 1] == 0) {
            n--;
        }
        return n <= 0;
    }
}
// @lc code=end

