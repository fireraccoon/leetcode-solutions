// @algorithm @lc id=100162 lang=java 
// @title string-rotation-lcci
package _____01_09_String_Rotation_LCCI;
// @test("waterbottle","erbottlewat")=true
// @test("aa","aba")=false
// @test("ab","ba")=true
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && s1.concat(s1).contains(s2);
    }
}