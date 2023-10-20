// @algorithm @lc id=100229 lang=java 
// @title check-subtree-lcci
package _____04_10_Check_SubTree_LCCI;
import algm.*;
// @test([1,2,3],[2])=true
// @test([1,null,2,4],[3,2])=false
// @test([1,2,3,4,5],[2])=false
// @test([],[2])=false
// @test([],[])=true
// @test([2],[])=false
// @test([161,164,162,165,175,163,168,178,166,204,181,205,167,172,169,null,186,180,209,null,null,190,200,null,215,211,170,182,177,173,176,null,198,212,188,null,null,null,216,201,null,null,null,null,null,171,210,null,185,null,187,174,218,193,227,223,null,null,236,199,null,null,null,null,null,183,179,232,null,197,233,null,null,191,237,null,null,239,194,234,null,null,null,null,null,208,null,null,189,219,184,null,null,null,213,null,null,null,214,null,null,null,null,206,217,null,null,226,null,null,196,230,229,null,192,224,null,null,222,235,207,null,220,null,null,null,231,null,null,null,null,202,195,228,null,null,null,null,null,null,null,null,null,null,null,238,225,null,203,null,null,null,null,null,null,null,221],[209])=true
import java.util.List;
import java.util.ArrayList;

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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null ^ t2 == null) {
            return false;
        }
        List<Integer> t1Preorder = new ArrayList<>();
        List<Integer> t2Preorder = new ArrayList<>();
        preorder(t1Preorder, t1);
        preorder(t2Preorder, t2);
        return contains(t1Preorder, t2Preorder);
    }
    boolean contains(List<Integer> s, List<Integer> p) {
        int m = s.size(), n = p.size();
        int[] pi = new int[n];
        int pre = 0;
        for (int i = 1; i < n; i++) {
            while (pre > 0 && !equals(p.get(pre), p.get(i))) {
                pre = pi[pre - 1];
            }
            if (equals(p.get(pre), p.get(i))) {
                pre++;
            }
            pi[i] = pre;
        }
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (equals(s.get(p1), p.get(p2))) {
                p1++;
                p2++;
            } else if (p2 > 0) {
                p2 = pi[p2 - 1];
            } else {
                p1++;
            }
        }
        return p2 == n;
    }
    void preorder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(root.val);
        preorder(ans, root.left);
        preorder(ans, root.right);
    }
    boolean equals(Integer a, Integer b) {
        return a == null ? b == null : a.equals(b);
    }
}