// @algorithm @lc id=100195 lang=java 
// @title stack-of-plates-lcci
package _____03_03_Stack_of_Plates_LCCI;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
class Solution {

    int capacity;

    List<Deque<Integer>> stacks = new LinkedList<>();

    public Solution(int cap) {
        capacity = cap;
    }

    public void push(int val) {
        if (capacity == 0) {
            return;
        }
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
            stacks.add(new LinkedList<>());
        }
        stacks.get(stacks.size() - 1).push(val);
    }

    public int pop() {
        if (capacity == 0 || stacks.isEmpty()) {
            return -1;
        }
        int index = stacks.size() - 1;
        Deque<Integer> stack = stacks.get(index);
        int ans = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return ans;
    }

    public int popAt(int index) {
        if (index >= stacks.size()) {
            return -1;
        }
        Deque<Integer> stack = stacks.get(index);
        int ans = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return ans;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */