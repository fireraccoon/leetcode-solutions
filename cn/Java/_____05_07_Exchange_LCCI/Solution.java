// @algorithm @lc id=100182 lang=java 
// @title exchange-lcci
package _____05_07_Exchange_LCCI;
// @test(2)=1
// @test(3)=3
public class Solution {
    public int exchangeBits(int num) {
        return 0x55555555 & num >>> 1 | 0xaaaaaaaa & num << 1;
    }
}