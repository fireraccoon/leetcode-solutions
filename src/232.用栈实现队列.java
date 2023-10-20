/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class MyQueue {

    private Deque<Integer> s1 = new LinkedList<>();

    private Deque<Integer> s2 = new LinkedList<>();

    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    private void solveAsQueue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public int pop() {
        solveAsQueue();
        return s2.pop();
    }

    public int peek() {
        solveAsQueue();
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

