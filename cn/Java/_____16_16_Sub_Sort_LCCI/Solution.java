// @algorithm @lc id=100356 lang=java 
// @title sub-sort-lcci
package _____16_16_Sub_Sort_LCCI;
// @test([1,2,4,7,10,11,7,12,6,7,16,18,19])=[3,9]
public class Solution {
    public int[] subSort(int[] array) {
        int n = array.length;
        int leftMaxIndex = 0, rightMinIndex = n - 1;
        while (leftMaxIndex < n - 1 && array[leftMaxIndex] <= array[leftMaxIndex + 1]) {
            leftMaxIndex++;
        }
        while (rightMinIndex >= 1 && array[rightMinIndex] >= array[rightMinIndex - 1]) {
            rightMinIndex--;
        }
        if (leftMaxIndex >= rightMinIndex) {
            return new int[] { -1, -1 };
        }

        int leftMax = array[leftMaxIndex], rightMin = array[rightMinIndex];
        for (int i = leftMaxIndex + 1; i < rightMinIndex; i++) {
            leftMax = Math.max(leftMax, array[i]);
            rightMin = Math.min(rightMin, array[i]);
        }

        while (rightMinIndex < n - 1 && array[rightMinIndex + 1] < leftMax) {
            rightMinIndex++;
        }
        while (leftMaxIndex > 0 && array[leftMaxIndex - 1] > rightMin) {
            leftMaxIndex--;
        }
        return new int[] { leftMaxIndex, rightMinIndex };
    }
}