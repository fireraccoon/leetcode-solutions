/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int numBulls = 0;
        int numCows = 0;
        int[] mapA = new int[10];
        int[] mapB = new int[10];
        for (int i = 0; i < n; i++) {
            char a = secret.charAt(i), b = guess.charAt(i);
            if (a == b) {
                numBulls++;
            } else {
                mapA[a - '0']++;
                mapB[b - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            numCows += Math.min(mapA[i], mapB[i]);
        }
        return new StringBuilder().append(numBulls).append('A').append(numCows).append('B').toString();
    }
}
// @lc code=end

