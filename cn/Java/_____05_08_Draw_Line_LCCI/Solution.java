// @algorithm @lc id=100196 lang=java 
// @title draw-line-lcci
package _____05_08_Draw_Line_LCCI;
// @test(1,32,30,31,0)=[3]
// @test(3,96,0,95,0)=[-1,-1,-1]
public class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int rowOffset = w / 32 * y, offset = x1 / 32;
        int bits = (1 << 31 - x1 % 32 << 1) - 1;
        while (offset < x2 / 32) {
            ans[rowOffset + offset] = bits;
            offset++;
            bits = 0xffffffff;
        }
        ans[rowOffset + offset] = bits & (0xffffffff << 31 - x2 % 32);
        return ans;
    }
}