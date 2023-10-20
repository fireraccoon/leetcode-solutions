/*
 * @lc app=leetcode.cn id=2336 lang=java
 *
 * [2336] 无限集中的最小数字
 */

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// @lc code=start
class SmallestInfiniteSet extends PriorityQueue<Integer> {

    public SmallestInfiniteSet() {
        super(Stream.iterate(1, x -> x + 1).limit(1001).collect(Collectors.toList()));
    }

    public int popSmallest() {
        int num = poll();
        while (!isEmpty() && peek() == num) {
            poll();
        }
        return num;
    }

    public void addBack(int num) {
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

