/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length(), ans = 0;
        for (int i = 0, count = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (i >= k - 1) {
                ans = Math.max(ans, count);
                if (isVowel(s.charAt(i - k + 1))) {
                    count--;
                }
            }
        }
        return ans;
    }
    boolean isVowel(char c) {
        return switch(c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
// @lc code=end

