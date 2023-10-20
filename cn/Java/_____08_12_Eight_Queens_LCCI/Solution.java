// @algorithm @lc id=100233 lang=java 
// @title eight-queens-lcci
package _____08_12_Eight_Queens_LCCI;
// @test(4)=[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] node = new int[n];
        dfs(ans, node, 0, 0, 0, 0);
        return ans;
    }
    void dfs(List<List<String>> ans, int[] node, int rowIndex, int columns, int leftTopDiagonal, int rightTopDiagonal) {
        if (rowIndex == node.length) {
            ans.add(generateChess(node));
            return;
        }
        int originColumns = columns;
        while (true) {
            int column = ~(columns | leftTopDiagonal | rightTopDiagonal) & (1 << node.length) - 1;
            column &= -column;
            if (column == 0) {
                return;
            }
            node[rowIndex] = Integer.bitCount(column - 1);
            dfs(ans, node, rowIndex + 1, originColumns | column, (leftTopDiagonal | column) >>> 1, (rightTopDiagonal | column) << 1);
            columns |= column;
        }
    }
    List<String> generateChess(int[] node) {
        List<String> chess = new ArrayList<>();
        char[] row = new char[node.length];
        Arrays.fill(row, '.');
        for (int i = 0; i < node.length; i++) {
            row[node[i]] = 'Q';
            chess.add(new String(row));
            row[node[i]] = '.';
        }
        return chess;
    }
}