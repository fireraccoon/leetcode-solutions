// @algorithm @lc id=100203 lang=java 
// @title binary-number-to-string-lcci
package _____05_02_Binary_Number_to_String_LCCI_1;
// @test(0.625)="0.101"
// @test(0.1)="ERROR"
public class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0 && sb.length() <= 32) {
            num *= 2D;
            sb.append((int) num);
            if (num >= 1D) {
                num -= 1D;
            }
        }
        return num == 0D ? sb.toString() : "ERROR";
    }
}