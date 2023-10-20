// @algorithm @lc id=1000029 lang=java 
// @title volume-of-histogram-lcci
package _____17_21_Volume_of_Histogram_LCCI_1;
// @test([0,1,0,2,1,0,1,3,2,1,2,1])=6
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int peek = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int w = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[peek];
                ans += w * h;
            }
            stack.push(i);
        }
        return ans;
    }
}