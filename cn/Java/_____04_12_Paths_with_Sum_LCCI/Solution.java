// @algorithm @lc id=1000009 lang=java 
// @title paths-with-sum-lcci
package _____04_12_Paths_with_Sum_LCCI;
import algm.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Map<Long, Integer> prefixSums = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        prefixSums.put(0L, 1);
        return dfs(root, 0, sum);
    }
    int dfs(TreeNode root, long sum, long target) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int ans = prefixSums.getOrDefault(sum - target, 0);
        prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        ans += dfs(root.left, sum, target) + dfs(root.right, sum, target);
        prefixSums.put(sum, prefixSums.get(sum) - 1);
        return ans;
    }
}