// @algorithm @lc id=100202 lang=java 
// @title pile-box-lcci
package _____08_13_Pile_Box_LCCI;
// @test([[1,1,1],[2,2,2],[3,3,3]])=6
// @test([[1,1,1],[2,3,4],[2,6,7],[3,4,5]])=10
// @test([[8,8,8],[10,9,8]])=8
// @test([[9,10,10],[8,8,9]])=19
import java.util.Arrays;

public class Solution {
    public int pileBox(int[][] box) {
        int n = box.length;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Arrays.sort(box, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += box[i][2];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}