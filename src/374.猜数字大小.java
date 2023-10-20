/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int middle = left + (right - left >> 1);
            switch (guess(middle)) {
                case -1: {
                    right = middle - 1;
                    break;
                }
                case 1: {
                    left = middle + 1;
                    break;
                }
                default: {
                    return middle;
                }
            }
        }
        return 0;
    }
}
// @lc code=end

class GuessGame {
    public int guess(int num) {
        throw new UnsupportedOperationException();
    }
}
