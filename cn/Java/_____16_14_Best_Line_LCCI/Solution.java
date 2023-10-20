// @algorithm @lc id=100354 lang=java 
// @title best-line-lcci
package _____16_14_Best_Line_LCCI;
// @test([[0,0],[1,1],[1,0],[2,0]])=[0,2]
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.List;

public class Solution {
    public int[] bestLine(int[][] points) {
        Map<Line, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line key = new Line(points[i], points[j]);
                List<int[]> pairs = map.get(key);
                if (pairs == null) {
                    pairs = new ArrayList<>();
                    map.put(key, pairs);
                }
                pairs.add(new int[] { i, j });
            }
        }

        int maxPoints = 0;
        int[] ans = new int[] { Integer.MAX_VALUE, 0 };
        for (List<int[]> pairs : map.values()) {
            if (pairs.size() > maxPoints) {
                maxPoints = pairs.size();
                ans = pairs.get(0);
            } else if (pairs.size() == maxPoints && (ans[0] > pairs.get(0)[0]
                || ans[0] == pairs.get(0)[0] && ans[1] > pairs.get(0)[1])) {
                ans = pairs.get(0);
            }
        }
        return ans;
    }

    private double round(double val) {
        return Math.round(val * 100D) / 100D;
    }

    private class Line {

        private int hash;

        public double k, b;

        public Line(int[] point1, int[] point2) {
            if (point1[0] == point2[0]) {
                k = Double.POSITIVE_INFINITY;
                b = point1[0];
            } else if (point1[1] == point2[1]) {
                k = 0D;
                b = point1[1];
            } else {
                k = (double) (point1[1] - point2[1]) / (point1[0] - point2[0]);
                b = point1[1] - k * point1[0];
            }
            hash = Objects.hash(round(k), round(b));
        }

        @Override
        public boolean equals(Object o) {
            return hash == o.hashCode();
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }
}