// @algorithm @lc id=100231 lang=java 
// @title coin-lcci
package _____08_11_Coin_LCCI_1;
// @test(5)=2
// @test(10)=4

import java.util.Arrays;
public class Solution {
    private final static int MOD = 1_000_000_007;
    private final static int[] moneys = new int[] { 1, 5, 10, 25 };
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= moneys[i]) {
                    dp[j] = (dp[j] + dp[j - moneys[i]]) % MOD;
                }
            }
        }
        return dp[n];
    }
}