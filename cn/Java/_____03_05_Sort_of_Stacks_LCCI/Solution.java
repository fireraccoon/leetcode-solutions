// @algorithm @lc id=100173 lang=java 
// @title sort-of-stacks-lcci
package _____03_05_Sort_of_Stacks_LCCI;
import java.util.Deque;
import java.util.LinkedList;

class SortedStack {

    private Deque<Integer> minStack = new LinkedList<>();

    private Deque<Integer> maxStack = new LinkedList<>();

    public SortedStack() {

    }

    public void push(int val) {
        while (!minStack.isEmpty() && minStack.peek() > val) {
            maxStack.push(minStack.pop());
        }
        while (!maxStack.isEmpty() && maxStack.peek() < val) {
            minStack.push(maxStack.pop());
        }
        minStack.push(val);
    }

    public void pop() {
        if (!isEmpty()) {
            rebuild();
            maxStack.pop();
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        rebuild();
        return maxStack.peek();
    }

    public boolean isEmpty() {
        return minStack.isEmpty() && maxStack.isEmpty();
    }

    private void rebuild() {
        while (!minStack.isEmpty()) {
            maxStack.push(minStack.pop());
        }
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */