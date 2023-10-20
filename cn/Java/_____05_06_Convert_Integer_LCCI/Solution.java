// @algorithm @lc id=100181 lang=java 
// @title convert-integer-lcci
package _____05_06_Convert_Integer_LCCI;
public class Solution {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}