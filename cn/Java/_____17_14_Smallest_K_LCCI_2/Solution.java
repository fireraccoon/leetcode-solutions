// @algorithm @lc id=1000021 lang=java 
// @title smallest-k-lcci
package _____17_14_Smallest_K_LCCI_2;
// @test([1,3,5,7,2,4,6,8],4)=[1,2,3,4]
import java.util.Arrays;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}