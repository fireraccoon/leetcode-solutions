/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int p1 = 0, p2 = 0;
        while (p1 < n1 || p2 < n2) {
            int v1 = 0, v2 = 0;
            for (; p1 < n1 && version1.charAt(p1) != '.'; p1++) {
                v1 = 10 * v1 + Character.digit(version1.charAt(p1), 10);
            }
            for (; p2 < n2 && version2.charAt(p2) != '.'; p2++) {
                v2 = 10 * v2 + Character.digit(version2.charAt(p2), 10);
            }
            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}
// @lc code=end

