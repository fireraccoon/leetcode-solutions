// @algorithm @lc id=100158 lang=java 
// @title is-unique-lcci
package _____01_01_Is_Unique_LCCI;
// @test("leetcode")=false
// @test("abc")=true
public class Solution {
    public boolean isUnique(String astr) {
        int n = astr.length();
        int counts = 0;
        for (int i = 0; i < n; i++) {
            int index = astr.charAt(i) - 'a';
            if ((counts >>> index & 1) == 1) {
                return false;
            }
            counts |= 1 << index;
        }
        return true;
    }
}