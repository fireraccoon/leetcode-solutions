// @algorithm @lc id=100260 lang=java 
// @title intersection-lcci
package _____16_03_Intersection_LCCI;
public class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] == end1[0] && start2[0] == end2[0]) {
            if (start1[0] == start2[0]) {
                int y = minPoint(start1[1], end1[1], start2[1], end2[1]);
                if (y != Integer.MAX_VALUE) {
                    return new double[] { start1[0], y };
                }
            }
            return new double[0];
        }

        if (start1[0] != end1[0] && start2[0] != end2[0]) {
            double k1 = ((double) start1[1] - end1[1]) / (start1[0] - end1[0]);
            double b1 = start1[1] - k1 * start1[0];
            double k2 = ((double) start2[1] - end2[1]) / (start2[0] - end2[0]);
            double b2 = start2[1] - k2 * start2[0];
            if (k1 != k2) {
                double x = (b2 - b1) / (k1 - k2);
                double y = k1 * x + b1;
                if (contains(start1, end1, x, y) && contains(start2, end2, x, y)) {
                    return new double[] { x, y };
                }
            } else if (b1 == b2) {
                int x = minPoint(start1[0], end1[0], start2[0], end2[0]);
                if (x != Integer.MAX_VALUE) {
                    return new double[] { x, k1 * x + b1 };
                }
            }
            return new double[0];
        }

        if (start1[0] == end1[0]) {
            int[] tmp = start1; start1 = start2; start2 = tmp;
            tmp = end1; end1 = end2; end2 = tmp;
        }
        double k = ((double) start1[1] - end1[1]) / (start1[0] - end1[0]);
        double b = start1[1] - k * start1[0];
        double x = start2[0];
        double y = k * x + b;
        if (contains(start1, end1, x, y) && contains(start2[1], end2[1], y)) {
            return new double[] { x, y };
        }
        return new double[0];
    }
    int minPoint(int start1, int end1, int start2, int end2) {
        int ans = Integer.MAX_VALUE;
        if (contains(start2, end2, start1)) {
            ans = Math.min(ans, start1);
        }
        if (contains(start2, end2, end1)) {
            ans = Math.min(ans, end1);
        }
        if (contains(start1, end1, start2)) {
            ans = Math.min(ans, start2);
        }
        if (contains(start1, end1, end2)) {
            ans = Math.min(ans, end2);
        }
        return ans;
    }
    boolean contains(int[] start, int[] end, double x, double y) {
        return contains(start[0], end[0], x) && contains(start[1], end[1], y);
    }
    boolean contains(int bound1, int bound2, double value) {
        return value >= bound1 && value <= bound2
            || value <= bound1 && value >= bound2;
    }
}