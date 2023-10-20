/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            max = Math.max(max, piles[i]);
        }

        int left = (int) ((sum + h - 1) / h), right = max / (h / piles.length) + 1;
        while (left < right) {
            int middle = left + (right - left >> 1);
            if (isPilesEaten(piles, h, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }
    boolean isPilesEaten(int[] piles, int time, int speed) {
        for (int i = 0; i < piles.length && time >= 0; i++) {
            time -= piles[i] % speed == 0 ? piles[i] / speed : piles[i] / speed + 1;
        }
        return time >= 0;
    }
}
// @lc code=end

