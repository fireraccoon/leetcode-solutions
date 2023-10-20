// @algorithm @lc id=1000021 lang=java 
// @title smallest-k-lcci
package _____17_14_Smallest_K_LCCI;
// @test([1,3,5,7,2,4,6,8],4)=[1,2,3,4]
import java.util.Arrays;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        randomQuickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }
    private void randomQuickSelect(int[] arr, int left, int right, int k) {
        int pivotIndex = randomInt(left, right);
        int pivot = arr[pivotIndex];
        swap(arr, left, pivotIndex);
        int pointer = left + 1, smaller = left, larger = right + 1;
        while (pointer < larger) {
            if (arr[pointer] < pivot) {
                swap(arr, pointer++, ++smaller);
            } else if (arr[pointer] > pivot) {
                swap(arr, pointer, --larger);
            } else {
                pointer++;
            }
        }
        swap(arr, left, smaller);
        if (smaller > k) {
            randomQuickSelect(arr, left, smaller - 1, k);
        } else if (larger <= k) {
            randomQuickSelect(arr, larger, right, k);
        }
    }
    private int randomInt(int left, int right) {
        return (int) ((right + 1 - left) * Math.random()) + left;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}