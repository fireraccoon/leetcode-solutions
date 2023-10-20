// @algorithm @lc id=100200 lang=java 
// @title bracket-lcci
package _____08_09_Bracket_LCCI;
// @test(3)=["((()))","(()())","(())()","()(())","()()()"]
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new char[n * 2], 0, n, n);
        return ans;
    }
    void dfs(List<String> ans, char[] node, int index, int lCount, int rCount) {
        if (lCount == 0 && rCount == 0) {
            ans.add(new String(node));
            return;
        }
        if (lCount < 0 || rCount < lCount) {
            return;
        }
        node[index] = '(';
        dfs(ans, node, index + 1, lCount - 1, rCount);
        node[index] = ')';
        dfs(ans, node, index + 1, lCount, rCount - 1);
    }
}