// @algorithm @lc id=100353 lang=java 
// @title bisect-squares-lcci
package _____16_13_Bisect_Squares_LCCI;
public class Solution {
    public double[] cutSquares(int[] square1, int[] square2) {
        double[] center1 = getSquareCenter(square1);
        double[] center2 = getSquareCenter(square2);
        if (center1[0] == center2[0]) {
            return new double[] {
                center1[0], Math.min(square1[1], square2[1]),
                center2[0], Math.max(top(square1), top(square2))
            };
        }

        if (center1[1] == center2[1]) {
            return new double[] {
                Math.min(square1[0], square2[0]), center1[1],
                Math.max(right(square1), right(square2)), center2[1]
            };
        }

        double[] points1 = intersect(square1, center1, center2);
        double[] points2 = intersect(square2, center1, center2);
        double[][] map = new double[][] {
            { points1[0], points1[1], points1[2], points1[3] },
            { points1[0], points1[1], points2[0], points2[1] },
            { points1[0], points1[1], points2[2], points2[3] },
            { points1[2], points1[3], points2[0], points2[1] },
            { points1[2], points1[3], points2[2], points2[3] },
            { points2[0], points2[1], points2[2], points2[3] }
        };

        int maxIndex = -1;
        double maxDistance = -1D;
        for (int i = 0; i < map.length; i++) {
            double dist = distance(map[i]);
            if (dist > maxDistance) {
                maxIndex = i;
                maxDistance = dist;
            }
        }
        return standOutput(map[maxIndex]);
    }
    private double[] standOutput(double[] output) {
        return output[0] < output[2] ? output
            : new double[] { output[2], output[3], output[0], output[1] };
    }
    private double distance(double[] points) {
        double sx = points[0] - points[2], sy = points[1] - points[3];
        return sx * sx + sy * sy;
    }
    private double[] intersect(int[] square, double[] point1, double[] point2) {
        double x1 = square[0], x2 = right(square), y3 = square[1], y4 = top(square);
        double y1 = (x1 - point1[0]) / (point1[0] - point2[0])
            * (point1[1] - point2[1]) + point1[1];
        double y2 = (x2 - point1[0]) / (point1[0] - point2[0])
            * (point1[1] - point2[1]) + point1[1];
        if (contains(y3, y4, y1)) {
            return new double[] { x1, y1, x2, y2};
        }
        double x3 = (y3 - point1[1]) / (point1[1] - point2[1])
            * (point1[0] - point2[0]) + point1[0];
        double x4 = (y4 - point1[1]) / (point1[1] - point2[1])
            * (point1[0] - point2[0]) + point1[0];
        return new double[] { x3, y3, x4, y4 };
    }
    private double[] getSquareCenter(int[] square) {
        return new double[] {
            square[0] + square[2] / 2D, square[1] + square[2] / 2D
        };
    }
    private boolean contains(double bound1, double bound2, double val) {
        return val >= bound1 && val <= bound2;
    }
    private int right(int[] square) {
        return square[0] + square[2];
    }
    private int top(int[] square) {
        return square[1] + square[2];
    }
}