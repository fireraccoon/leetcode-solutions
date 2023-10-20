/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    @SuppressWarnings("unchecked")
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> nums = new ArrayList<>();
        List<Character> options = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                while (++i < n && Character.isDigit(expression.charAt(i))) {
                    number = 10 * number + Character.getNumericValue(expression.charAt(i));
                }
                nums.add(number);
            } else {
                options.add(c);
                i++;
            }
        }
        n = nums.size();
        List<Integer>[][] dp = new List[n][n];
        for (i = 0; i < n; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(nums.get(i));
        }
        for (i = 1; i < n; i++) {
            for (int j = 0; i + j < n; j++) {
                dp[j][i] = new ArrayList<>();
                for (int k = 0; k < i; k++) {
                    for (int a : dp[j][k]) {
                        for (int b : dp[j + k + 1][i - k - 1]) {
                            dp[j][i].add(compute(a, b, options.get(j + k)));
                        }
                    }
                }
            }
        }
        return dp[0][options.size()];
    }
    int compute(int a, int b, char option) {
        return switch (option) {
            case '+' -> a + b;
            case '-' -> a - b;
            default -> a * b;
        };
    }
}
// @lc code=end

