// @algorithm @lc id=100352 lang=java 
// @title diving-board-lcci
package _____16_11_Diving_Board_LCCI;
// @test(1,2,3)=[3,4,5,6]
// @test(1,1,0)=[]
// @test(1,1,100000)=[100000]
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int pointer = shorter * k, diff = longer - shorter;
        if (diff == 0) {
            return new int[] { pointer };
        }
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = pointer;
            pointer += diff;
        }
        return ans;
    }
}