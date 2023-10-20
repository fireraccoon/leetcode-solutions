// @algorithm @lc id=1000025 lang=java 
// @title add-without-plus-lcci
package _____17_01_Add_Without_Plus_LCCI;
// @test(1,1)=2
public class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}