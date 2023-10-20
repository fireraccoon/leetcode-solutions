/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class MinStack {

    Deque<Long> stack = new LinkedList<>();

    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        stack.push((long) val - min);
        min = Math.min(min, val);
    }

    public void pop() {
        long peek = stack.peek();
        if (peek < 0) {
            min -= peek;
        }
        stack.pop();
    }

    public int top() {
        long peek = stack.peek();
        if (peek < 0) {
            return min;
        } else {
            return (int) (peek + min);
        }
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

