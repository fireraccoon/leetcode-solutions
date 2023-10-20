// @algorithm @lc id=100348 lang=java 
// @title permutation-ii-lcci
package _____08_08_Permutation_II_LCCI;
// @test("qqe")=["qqe","qeq","eqq"]
// @test("ab")=["ab","ba"]
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public String[] permutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(ans, S.toCharArray(), 0);
        return ans.toArray(new String[ans.size()]);
    }
    void dfs(List<String> ans, char[] node, int index) {
        if (index == node.length - 1) {
            ans.add(new String(node));
            return;
        }
        boolean[] visited = new boolean[52];
        for (int i = index; i < node.length; i++) {
            int ai = getAlphaIndex(node[i]);
            if (visited[ai]) {
                continue;
            }
            visited[ai] = true;
            swap(node, index, i);
            dfs(ans, node, index + 1);
            swap(node, index, i);
        }
    }
    int getAlphaIndex(char c) {
        return c < 'a' ? c - 'A' + 26 : c - 'a';
    }
    void swap(char[] array, int i, int j) {
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}