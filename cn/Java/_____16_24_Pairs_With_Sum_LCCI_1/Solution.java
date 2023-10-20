// @algorithm @lc id=1000042 lang=java 
// @title pairs-with-sum-lcci
package _____16_24_Pairs_With_Sum_LCCI_1;
// @test([5,6,5],11)=[[5,6]]
// @test([5,6,5,6],11)=[[5,6],[5,6]]
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans.add(List.of(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}