// @algorithm @lc id=1000028 lang=java 
// @title continuous-median-lcci
package _____17_20_Continuous_Median_LCCI;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (maxHeap.peek() > num) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2D;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */