// @algorithm @lc id=1000017 lang=java 
// @title factorial-zeros-lcci
package _____16_05_Factorial_Zeros_LCCI;
// @test(3)=0
// @test(5)=1
// @test(1808548329)=452137076
public class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        long base = 5;
        while (base <= n) {
            ans += n / base;
            base *= 5;
        }
        return ans;
    }
}