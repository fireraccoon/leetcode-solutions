// @algorithm @lc id=1000012 lang=java 
// @title sorted-merge-lcci
package _____10_01_Sorted_Merge_LCCI;
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int pointer = m + n - 1;
        for (int i = m - 1, j = n - 1; j >= 0; pointer--) {
            if (i < 0 || A[i] < B[j]) {
                A[pointer] = B[j--];
            } else {
                A[pointer] = A[i--];
            }
        }
    }
}