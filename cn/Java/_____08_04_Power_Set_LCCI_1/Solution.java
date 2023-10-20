// @algorithm @lc id=100198 lang=java 
// @title power-set-lcci
package _____08_04_Power_Set_LCCI_1;
// @test([1,2,3])=[[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    @SuppressWarnings("unchecked")
    public List<List<Integer>> subsets(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of());
        for (int i = 0; i < nums.length; i++) {
            for (int j = queue.size(); j > 0; j--) {
                List<Integer> node = queue.poll();
                queue.offer(node);
                List<Integer> next = new LinkedList<>(node);
                next.add(nums[i]);
                queue.offer(next);
            }
        }
        return (List<List<Integer>>) queue;
    }
}