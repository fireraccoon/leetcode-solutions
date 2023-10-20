/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i + ans < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int key = 0;
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                if (deltaX < 0) {
                    deltaY = -deltaY;
                    deltaX = -deltaX;
                }
                if (deltaY < 0) {
                    deltaY = -deltaY;
                    key = 0x80000000;
                }
                if (deltaX == 0) {
                    deltaY = Integer.MIN_VALUE;
                } else if (deltaY == 0) {
                    deltaX = 0;
                } else {
                    int gcd = gcd(deltaX, Math.abs(deltaY));
                    deltaX /= gcd;
                    deltaY /= gcd;
                }
                key |= deltaX << 10 | deltaY;
                map.put(key, map.getOrDefault(key, 1) + 1);
            }
            for (int v : map.values()) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
    int gcd(int x, int y) {
        int tmp;
        while (y != 0) {
            tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
// @lc code=end

