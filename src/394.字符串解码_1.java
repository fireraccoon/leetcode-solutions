/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<Integer> frequencyStack = new LinkedList<>();
        Deque<StringBuilder> stringStack = new LinkedList<>();
        frequencyStack.push(1);
        stringStack.push(new StringBuilder());
        for (int i = 0; i < n;) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int number = c - '0';
                while (++i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                }
                frequencyStack.push(number);
                stringStack.push(new StringBuilder());
                i++;
            } else if (Character.isLetter(c)) {
                StringBuilder sb = stringStack.peek();
                sb.append(c);
                while (++i < n && Character.isLetter(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            } else {
                StringBuilder sb = stringStack.pop();
                for (int j = frequencyStack.pop(); j > 0; j--) {
                    stringStack.peek().append(sb);
                }
                i++;
            }
        }
        return stringStack.peek().toString();
    }
}
// @lc code=end

