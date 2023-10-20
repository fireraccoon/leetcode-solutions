// @algorithm @lc id=1000028 lang=java 
// @title continuous-median-lcci
package _____17_20_Continuous_Median_LCCI_1;
import java.util.TreeMap;
import java.util.Map.Entry;

class MedianFinder {

    private TreeMap<Integer, Integer> treeMap;

    private int lessThanEqualsMedian, greaterThanEqualsMedian;

    private int lessThanEqualsMedianCount = 0, greaterThanEqualsMedianCount = 0;

    private int size = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int num) {
        treeMap.merge(num, 1, Integer::sum);
        if (++size == 1) {
            lessThanEqualsMedian = num;
            greaterThanEqualsMedian = num;
            lessThanEqualsMedianCount++;
            greaterThanEqualsMedianCount++;
        } else if ((size & 1) == 0) {
            if (num >= lessThanEqualsMedian) {
                greaterThanEqualsMedianCount++;
                if (greaterThanEqualsMedianCount > treeMap.get(greaterThanEqualsMedian)) {
                    greaterThanEqualsMedian = treeMap.higherKey(greaterThanEqualsMedian);
                    greaterThanEqualsMedianCount = 1;
                }
            } else {
                lessThanEqualsMedianCount--;
                if (lessThanEqualsMedianCount == 0) {
                    Entry<Integer, Integer> next = treeMap.lowerEntry(lessThanEqualsMedian);
                    lessThanEqualsMedian = next.getKey();
                    lessThanEqualsMedianCount = next.getValue();
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
                if (greaterThanEqualsMedianCount == 0) {
                    Entry<Integer, Integer> entry = treeMap.lowerEntry(greaterThanEqualsMedian);
                    greaterThanEqualsMedian = entry.getKey();
                    greaterThanEqualsMedianCount = entry.getValue();
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