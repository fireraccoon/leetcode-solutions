// @algorithm @lc id=1000034 lang=java 
// @title number-of-2s-in-range-lcci
package _____17_06_Number_Of_2s_In_Range_LCCI;
// @test(25)=9
public class Solution {
    public int numberOf2sInRange(int n) {
        int ans = 0;
        for (int base = 1; base <= n; base *= 10) {
            int digit = n / base % 10;
            if (digit <= 2) {
                ans += n / (base * 10) * base;
            } else {
                ans += (n / (base * 10) + 1) * base;
            }
            if (digit == 2) {
                ans += base == 1 ? 1 : n % base + 1;
            }
        }
        return ans;
    }
}