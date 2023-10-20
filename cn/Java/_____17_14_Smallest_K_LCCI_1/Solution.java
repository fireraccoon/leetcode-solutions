// @algorithm @lc id=1000021 lang=java 
// @title smallest-k-lcci
package _____17_14_Smallest_K_LCCI_1;
// @test([1,3,5,7,2,4,6,8],4)=[4,2,3,1]
import java.util.PriorityQueue;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.stream().mapToInt(Integer::valueOf).toArray();
    }
}