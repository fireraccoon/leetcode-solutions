// @algorithm @lc id=100172 lang=java 
// @title three-in-one-lcci
package _____03_01_Three_in_One_LCCI;
class TripleInOne {

    private int stackSize;

    private int[] pointer;

    private int[] tripleStack;

    public TripleInOne(int stackSize) {
        pointer = new int[] { 0, stackSize, stackSize * 2 };
        this.stackSize = stackSize;
        tripleStack = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (pointer[stackNum] < (stackNum + 1) * stackSize) {
            tripleStack[pointer[stackNum]++] = value;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return tripleStack[--pointer[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return tripleStack[pointer[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return pointer[stackNum] == stackSize * stackNum;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */