/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length(), n = magazine.length();
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            if (--map[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

