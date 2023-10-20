// @algorithm @lc id=100180 lang=java 
// @title insert-into-bits-lcci
package _____05_01_Insert_Into_Bits_LCCI;
// @test(2032243561, 10, 24, 29)=1243714409
// @test(1143207437, 1017033, 11, 31)=2082885133
public class Solution {
    public int insertBits(int N, int M, int i, int j) {
        int mask = (0xffffffff << j << 1) + ((1 << i) - 1);
        return N & mask | M << i;
    }
}