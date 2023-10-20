// @algorithm @lc id=1000029 lang=java 
// @title volume-of-histogram-lcci
package _____17_21_Volume_of_Histogram_LCCI_2;
// @test([0,1,0,2,1,0,1,3,2,1,2,1])=6
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMaxs = new int[n];
        leftMaxs[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], height[i]);
        }

        int ans = 0, rightMax = 0;
        for (int i = n - 1; i > 0; i--) {
            ans += Math.max(0, Math.min(rightMax, leftMaxs[i - 1]) - height[i]);
            rightMax = Math.max(rightMax, height[i]);
        }
        return ans;
    }
}