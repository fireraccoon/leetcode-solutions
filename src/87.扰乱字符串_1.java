/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    int memory[][][];
    public boolean isScramble(String s1, String s2) {
        memory = new int[s1.length()][s2.length()][s1.length()];
        return partition(s1, s2, 0, 0, s1.length());
    }
    boolean partition(String s1, String s2, int l1, int l2, int length) {
        if (memory[l1][l2][length - 1] != 0) {
            return memory[l1][l2][length - 1] == 1;
        }
        if (isMatch(s1, s2, l1, l2, length)) {
            boolean isScramble = length == 1;
            for (int i = 1; i < length && !isScramble; i++) {
                isScramble |= partition(s1, s2, l1, l2, i) && partition(s1, s2, l1 + i, l2 + i, length - i)
                    || partition(s1, s2, l1, l2 + length - i, i) && partition(s1, s2, l1 + i, l2, length - i);
            }
            memory[l1][l2][length - 1] = isScramble ? 1 : -1;
            return isScramble;
        } else {
            memory[l1][l2][length - 1] = -1;
            return false;
        }
    }
    boolean isMatch(String s1, String s2, int l1, int l2, int length) {
        char[] map = new char[26];
        for (int i = 0; i < length; i++) {
            map[s1.charAt(l1 + i) - 'a']++;
            map[s2.charAt(l2 + i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

