/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            } else {
                int peek = stack.pop();
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(peek);
            }
        }
        return stack.size();
    }
}
// @lc code=end

