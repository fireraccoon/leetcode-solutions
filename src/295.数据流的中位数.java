/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

import java.util.TreeMap;

// @lc code=start
import java.util.Map.Entry;

class MedianFinder {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    int lessThanEqualsMedian, greaterThanEqualsMedian;

    int lessThanEqualsMedianCount = 1, greaterThanEqualsMedianCount = 1;

    int size = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        if (++size == 1) {
            lessThanEqualsMedian = num;
            greaterThanEqualsMedian = num;
        } else if (size % 2 == 0) {
            if (num >= lessThanEqualsMedian) {
                greaterThanEqualsMedianCount++;
                if (greaterThanEqualsMedianCount > treeMap.get(greaterThanEqualsMedian)) {
                    greaterThanEqualsMedian = treeMap.higherKey(greaterThanEqualsMedian);
                    greaterThanEqualsMedianCount = 1;
                }
            } else {
                lessThanEqualsMedianCount--;
                if (lessThanEqualsMedianCount < 1) {
                    Entry<Integer, Integer> node = treeMap.lowerEntry(lessThanEqualsMedian);
                    lessThanEqualsMedian = node.getKey();
                    lessThanEqualsMedianCount = node.getValue();
                }
            }
        } else {
            if (num >= lessThanEqualsMedian) {
                lessThanEqualsMedianCount++;
                if (lessThanEqualsMedianCount > treeMap.get(lessThanEqualsMedian)) {
                    lessThanEqualsMedian = treeMap.higherKey(lessThanEqualsMedian);
                    lessThanEqualsMedianCount = 1;
                }
            }
            if (num < greaterThanEqualsMedian) {
                greaterThanEqualsMedianCount--;
                if (greaterThanEqualsMedianCount < 1) {
                    Entry<Integer, Integer> node = treeMap.lowerEntry(greaterThanEqualsMedian);
                    greaterThanEqualsMedian = node.getKey();
                    greaterThanEqualsMedianCount = node.getValue();
                }
            }
        }
    }

    public double findMedian() {
        return (lessThanEqualsMedian + greaterThanEqualsMedian) / 2D;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

