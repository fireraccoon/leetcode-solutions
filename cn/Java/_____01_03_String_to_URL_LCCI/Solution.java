// @algorithm @lc id=100160 lang=java 
// @title string-to-url-lcci
package _____01_03_String_to_URL_LCCI;
// @test("Mr John Smith    ",13)="Mr%20John%20Smith"
// @test("               ",5)="%20%20%20%20%20"
// @test("ds sdfs afs sdfa dfssf asdf             ",27)="ds%20sdfs%20afs%20sdfa%20dfssf%20asdf"
public class Solution {
    public String replaceSpaces(String S, int length) {
        byte[] chars = S.getBytes();
        int i = chars.length - 1;
        for (int j = length - 1; j >= 0; j--) {
            if (chars[j] != ' ') {
                chars[i--] = chars[j];
            } else {
                chars[i--] = '0';
                chars[i--] = '2';
                chars[i--] = '%';
            }
        }
        return new String(chars, i + 1, chars.length - i - 1);
    }
}