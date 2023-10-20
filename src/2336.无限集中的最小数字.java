/*
 * @lc app=leetcode.cn id=2336 lang=java
 *
 * [2336] 无限集中的最小数字
 */

import java.util.PriorityQueue;

// @lc code=start
class SmallestInfiniteSet extends PriorityQueue<Integer> {

    int minimum = 1;

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (isEmpty() || peek() >= minimum) {
            clear();
            return minimum++;
        }
        int ans = poll();
        while (!isEmpty() && peek() == ans) {
            poll();
        }
        return ans;
    }

    public void addBack(int num) {
        if (num >= minimum) {
            return;
        }
        offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// @lc code=end

