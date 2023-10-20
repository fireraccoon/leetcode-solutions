// @algorithm @lc id=100203 lang=java 
// @title binary-number-to-string-lcci
package _____05_02_Binary_Number_to_String_LCCI;
// @test(0.625)="0.101"
// @test(0.1)="ERROR"
// @test(0.953125)="0.111101"
public class Solution {

    private final static String ERROR = "ERROR";

    public String printBin(double num) {
        long bits = Double.doubleToLongBits(num);
        long exponent = ((bits & 0x7ff0000000000000L) >> 52) - 0x3ff;
        if (exponent <= -30L) {
            return ERROR;
        }

        StringBuilder sb = new StringBuilder("0.")
            .append("0".repeat((int) -exponent - 1))
            .append(1);

        long mantissa = bits & 0x000fffffffffffffL;
        if (mantissa << 44 + sb.length() != 0L) {
            return ERROR;
        }

        long mask = 0x0008000000000000L;
        while (mantissa != 0L) {
            int bit = (mantissa & mask) == mask ? 1 : 0;
            sb.append(bit);
            if (bit == 1) {
                mantissa ^= mask;
            }
            mask >>= 1;
        }
        return sb.toString();
    }
}