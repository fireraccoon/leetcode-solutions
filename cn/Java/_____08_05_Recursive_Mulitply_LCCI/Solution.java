// @algorithm @lc id=100199 lang=java 
// @title recursive-mulitply-lcci
package _____08_05_Recursive_Mulitply_LCCI;
// @test(1,10)=10
// @test(3,4)=12
// @test(45,56)=2520
public class Solution {
    public int multiply(int A, int B) {
        return B == 0
            ? 0
            : (B & 1) == 0
                ? multiply(A, B >> 1) << 1
                : A + (multiply(A, B >> 1) << 1);
    }
}