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
        int ans = 0, max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                if (points[i][0] == points[j][0]) {
                    sb.append('|');
                    sb.append(points[i][0]);
                } else {
                    float k = (points[i][1] - points[j][1]);
                    k /= (points[i][0] - points[j][0]);
                    sb.append(k == 0f ? 0f : k);
                    sb.append('|');
                    sb.append(Math.round((points[i][1] - k * points[i][0]) * 100) / 100f);
                }
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (int i : map.values()) {
            max = Math.max(i, max);
        }
        while (ans * (ans + 1) / 2 != max) {
            ans++;
        }
        return ++ans;
    }
}
// @lc code=end

