/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        int[] pi = new int[l2];
        pi[0] = 0;
        for (int i = 1; i < l2; i++) {
            int bias = pi[i - 1];
            while (bias > 0 && needle.charAt(i) != needle.charAt(bias)) {
                bias = pi[bias - 1];
            }
            pi[i] = bias;
            if (needle.charAt(i) == needle.charAt(bias)) {
                pi[i]++;
            }
        }
        int p1 = 0, p2 = 0;
        while (p1 < l1 && p2 < l2) {
            if (haystack.charAt(p1) == needle.charAt(p2)) {
                p2++;
                p1++;
            } else if (p2 > 0) {
                p2 = pi[p2 - 1];
            } else {
                p1++;
            }
        }
        return p2 == l2 ? p1 - l2 : -1;
    }
}
// @lc code=end

