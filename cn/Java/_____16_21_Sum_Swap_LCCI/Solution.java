// @algorithm @lc id=1000048 lang=java 
// @title sum-swap-lcci
package _____16_21_Sum_Swap_LCCI;
// @test([4,1,2,1,1,2],[3,6,3,3])=[1,3]
// @test([1,2,3],[4,5,6])=[]
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sumDiff = sum(array1) - sum(array2);
        if (sumDiff == 0 || sumDiff % 2 != 0) {
            return new int[0];
        }
        sumDiff >>= 1;

        Set<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            targetSet.add(array1[i] - sumDiff);
        }
        for (int i = 0; i < array2.length; i++) {
            if (targetSet.contains(array2[i])) {
                return new int[] { array2[i] + sumDiff, array2[i] };
            }
        }
        return new int[0];
    }
    private int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}