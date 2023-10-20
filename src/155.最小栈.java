/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class MinStack {

    private Deque<Integer> stack = new LinkedList<>();

    private Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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

