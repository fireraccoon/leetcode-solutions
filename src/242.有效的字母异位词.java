/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        int[] diff = new int[26];
        for (int i = 0; i < n; i++) {
            diff[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            int c = t.charAt(i) - 'a';
            diff[c]--;
            if (diff[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

