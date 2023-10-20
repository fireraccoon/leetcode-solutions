/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private List<Integer>[][] memory;
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
        memory = new List[nums.size()][nums.size()];
        return partition(nums, options, 0, options.size());
    }
    List<Integer> partition(List<Integer> nums, List<Character> options, int left, int right) {
        if (memory[left][right] == null) {
            memory[left][right] = new ArrayList<>();
        } else {
            return memory[left][right];
        }
        List<Integer> ans = memory[left][right];
        if (left == right) {
            ans.add(nums.get(left));
            return ans;
        }
        for (int i = left; i < right; i++) {
            List<Integer> leftAns = partition(nums, options, left, i);
            List<Integer> rightAns = partition(nums, options, i + 1, right);
            for (int a : leftAns) {
                for (int b : rightAns) {
                    ans.add(compute(a, b, options.get(i)));
                }
            }
        }
        return ans;
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

