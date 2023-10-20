// @algorithm @lc id=100231 lang=java 
// @title coin-lcci
package _____08_11_Coin_LCCI;
// @test(5)=2
// @test(10)=4
public class Solution {
    private static final int MOD = 1_000_000_007;
    public int waysToChange(int n) {
        int ans = 0;
        for (int i = 0; i * 25 <= n; i++) {
            int rest_25 = n - i * 25;
            int max_10 = rest_25 / 10;
            int max_5 = rest_25 % 10 / 5;
            ans = (ans + S_n(2 * max_10 + max_5 + 1, max_5 + 1, -2)) % MOD;
        }
        return ans;
    }
    int S_n(int a_1, int a_n, int d) {
        long n = (a_n - a_1) / d + 1;
        return (int) (((a_1 + a_n) * n / 2) % MOD);
    }
}