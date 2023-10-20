// @algorithm @lc id=1000037 lang=java 
// @title get-kth-magic-number-lcci
package _____17_09_Get_Kth_Magic_Number_LCCI;
// @test(5)=9
public class Solution {
    public int getKthMagicNumber(int k) {
        int[] factors = new int[] { 3, 5, 7 };
        int[] pointers = new int[] { 1, 1, 1 };
        int[] dp = new int[k + 1];
        dp[1] = 1;
        for (int i = 2; i <= k; i++) {
            int[] nexts = new int[pointers.length];
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < nexts.length; j++) {
                nexts[j] = dp[pointers[j]] * factors[j];
                dp[i] = Math.min(dp[i], nexts[j]);
            }
            for (int j = 0; j < nexts.length; j++) {
                if (dp[i] == nexts[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[k];
    }
}