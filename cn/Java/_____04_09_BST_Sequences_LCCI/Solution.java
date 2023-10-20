// @algorithm @lc id=1000010 lang=java 
// @title bst-sequences-lcci
package _____04_09_BST_Sequences_LCCI;
// @test([2,1,3])=[[2,1,3],[2,3,1]]
// @test([4,1,null,null,3,2])=[[4,1,3,2]]
// @test([])=[[]]
// @test([5,2,null,1,4,null,null,3])=[[5,2,1,4,3],[5,2,4,1,3],[5,2,4,3,1]]
import algm.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            return List.of(List.of());
        }

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        dfs(ans, queue, new LinkedList<>());
        return ans;
    }
    void dfs(List<List<Integer>> ans, LinkedList<TreeNode> queue, LinkedList<Integer> path) {
        if (queue.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.remove(i);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            path.add(node.val);
            dfs(ans, queue, path);
            path.removeLast();
            if (node.right != null) {
                queue.removeLast();
            }
            if (node.left != null) {
                queue.removeLast();
            }
            queue.add(i, node);
        }
    }
}