/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(s.charAt(left))) {
                left++;
            }
            while (left < right && !isVowel(s.charAt(right))) {
                right--;
            }
            char c = chars[left];
            chars[left++] = chars[right];
            chars[right--] = c;
        }
        return new String(chars);
    }
    boolean isVowel(char c) {
        return switch(c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
// @lc code=end

