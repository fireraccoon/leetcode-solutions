// @algorithm @lc id=100258 lang=java 
// @title swap-numbers-lcci
package _____16_01_Swap_Numbers_LCCI;
// @test([1,2])=[2,1]
public class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}