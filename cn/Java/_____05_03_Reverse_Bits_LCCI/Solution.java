// @algorithm @lc id=100230 lang=java 
// @title reverse-bits-lcci
package _____05_03_Reverse_Bits_LCCI;
// @test(1775)=8
// @test(7)=4
// @test(0)=1
// @test(-2147483648)=2
// @test(-1)=32
public class Solution {
    public int reverseBits(int num) {
        int ans = 0;
        int left = 0, right = 0;
        while (left < 32 && right < 32) {
            while (right < 32 && (num >>> right & 1) == 1) {
                right++;
            }
            int nextLeft = ++right;
            while (right < 32 && (num >>> right & 1) == 1) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left = nextLeft;
        }
        return Math.min(ans, 32);
    }
}