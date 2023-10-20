// @algorithm @lc id=100231 lang=java 
// @title coin-lcci
package _____08_11_Coin_LCCI_2;
// @test(5)=2
// @test(10)=4
// @test(15)=6
import java.util.Arrays;

public class Solution {
    private final static int MOD = 1_000_000_007;
    private final static int[] moneys = new int[] { 1, 5, 10, 25 };
    public int waysToChange(int n) {
        int[][] dp = new int[4][n + 1];
        dp[0][0] = dp[1][0] = dp[2][0] = dp[3][0] = 1;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= j / moneys[i]; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * moneys[i]]) % MOD;
                }
            }
        }
        return dp[3][n];
    }
}