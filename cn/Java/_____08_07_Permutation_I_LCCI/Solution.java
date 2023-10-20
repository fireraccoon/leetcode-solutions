// @algorithm @lc id=100241 lang=java 
// @title permutation-i-lcci
package _____08_07_Permutation_I_LCCI;
// @test("qwe")=["qwe","qew","wqe","weq","ewq","eqw"]
// @test("ab")=["ab","ba"]
import java.util.ArrayList;
import java.util.List;

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
        for (int i = index; i < node.length; i++) {
            swap(node, index, i);
            dfs(ans, node, index + 1);
            swap(node, index, i);
        }
    }
    void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}