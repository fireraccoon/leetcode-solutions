// @algorithm @lc id=1000036 lang=java 
// @title circus-tower-lcci
package _____17_08_Circus_Tower_LCCI;
// @test([65,70,56,75,60,68],[100,150,90,190,95,110])=6
import java.util.Arrays;

public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> {
            if (height[i] == height[j]) {
                return weight[j] - weight[i];
            }
            return height[i] - height[j];
        });

        int len = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int index = binarySearch(dp, weight[indices[i]], 0, len);
            dp[index] = weight[indices[i]];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
    private int binarySearch(int[] array, int target, int left, int right) {
        while (left < right) {
            int middle = left + (right - left >> 1);
            if (array[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }
}