/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

import java.util.PriorityQueue;

// @lc code=start
class MedianFinder {

    private PriorityQueue<Integer> lessThanEqualsMedian = new PriorityQueue<>((a, b) -> b.compareTo(a));

    private PriorityQueue<Integer> greaterThanMedian = new PriorityQueue<>();

    public MedianFinder() {
        
    }

    public void addNum(int num) {
        if (lessThanEqualsMedian.isEmpty()) {
            lessThanEqualsMedian.offer(num);
        } else if (num <= findMedian()) {
            lessThanEqualsMedian.offer(num);
            if (lessThanEqualsMedian.size() > greaterThanMedian.size() + 1) {
                greaterThanMedian.offer(lessThanEqualsMedian.poll());
            }
        } else {
            greaterThanMedian.offer(num);
            if (greaterThanMedian.size() > lessThanEqualsMedian.size()) {
                lessThanEqualsMedian.offer(greaterThanMedian.poll());
            }
        }
    }

    public double findMedian() {
        if (lessThanEqualsMedian.size() != greaterThanMedian.size()) {
            return lessThanEqualsMedian.peek();
        } else {
            return (lessThanEqualsMedian.peek() + greaterThanMedian.peek()) / 2D;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

