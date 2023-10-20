// @algorithm @lc id=100261 lang=java 
// @title tic-tac-toe-lcci
package _____16_04_Tic_Tac_Toe_LCCI;
// @test(["O X"," XO","X O"])="X"
// @test(["OOX","XXO","OXO"])="Draw"
// @test(["OOX","XXO","OX "])="Pending"
// @test(["OX ","OX ","O  "])="O"
public class Solution {
    public String tictactoe(String[] board) {
        boolean result = isWin(board, 'O');
        if (result) {
            return "O";
        }
        result = isWin(board, 'X');
        if (result) {
            return "X";
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains(" ")) {
                return "Pending";
            }
        }
        return "Draw";
    }
    boolean isWin(String[] board, char target) {
        int n = board.length;
        boolean[] columns = new boolean[n];
        boolean leftTopDiagonal = false, rightTopDiagonal = false;
        for (int i = 0; i < n; i++) {
            boolean row = false;
            for (int j = 0; j < n; j++) {
                boolean ne = board[i].charAt(j) != target;
                row |= ne;
                columns[j] |= ne;
            }
            if (!row) {
                return true;
            }
            leftTopDiagonal |= board[i].charAt(i) != target;
            rightTopDiagonal |= board[i].charAt(n - i - 1) != target;
        }
        if (!leftTopDiagonal || !rightTopDiagonal) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (!columns[i]) {
                return true;
            }
        }
        return false;
    }
}