// @algorithm @lc id=100170 lang=java 
// @title implement-queue-using-stacks-lcci
package _____03_04_Implement_Queue_using_Stacks_LCCI;
import java.util.Deque;
import java.util.LinkedList;
class MyQueue {

    private Deque<Integer> stackInput = new LinkedList<>();

    private Deque<Integer> stackOutput = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackInput.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackOutput.isEmpty()) {
            rebuild();
        }
        return stackOutput.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackOutput.isEmpty()) {
            rebuild();
        }
        return stackOutput.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackInput.isEmpty() && stackOutput.isEmpty();
    }

    private void rebuild() {
        while (!stackInput.isEmpty()) {
            stackOutput.push(stackInput.pop());
        }
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