// @algorithm @lc id=1000015 lang=java 
// @title hanota-lcci
package _____08_06_Hanota_LCCI;
import java.util.List;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }
    void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(A, C, B, n - 1);
        C.add(A.remove(A.size() - 1));
        move(B, A, C, n - 1);
    }
}