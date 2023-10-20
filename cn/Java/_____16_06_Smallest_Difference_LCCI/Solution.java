// @algorithm @lc id=100262 lang=java 
// @title smallest-difference-lcci
package _____16_06_Smallest_Difference_LCCI;
// @test([1,3,15,11,2],[23,127,235,19,8],3)=3
import java.util.Arrays;

public class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        long ans = Integer.MAX_VALUE;
        while (ans > 0L && p1 < a.length && p2 < b.length) {
            ans = Math.min(ans, Math.abs((long) a[p1] - b[p2]));
            if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return (int) ans;
    }
}