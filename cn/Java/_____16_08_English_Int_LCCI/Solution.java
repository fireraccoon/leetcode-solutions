// @algorithm @lc id=1000018 lang=java 
// @title english-int-lcci
package _____16_08_English_Int_LCCI;
// @test(123)="One Hundred Twenty Three"
// @test(12345)="Twelve Thousand Three Hundred Forty Five"
// @test(1234567)="One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// @test(1234567891)="One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
public class Solution {
    private String[] ones = new String[] { "Zero", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine" };
    private String[] elevenToNinetween = new String[] { "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private String[] tens = new String[] { "", "Ten", "Twenty",
        "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private String[] bases = new String[] { "", "Thousand",
        "Million", "Billion" };
    public String numberToWords(int num) {
        if (num == 0) {
            return ones[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int triple = num % 1_000;
            if (triple > 0) {
                sb = tripleToWords(triple).append(' ')
                    .append(bases[i]).append(' ').append(sb);
            }
            num /= 1_000;
        }
        return sb.toString().trim();
    }
    private StringBuilder tripleToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(ones[num / 100]).append(" Hundred").append(' ');
            num %= 100;
        }
        if (num >= 11 && num < 20) {
            return sb.append(elevenToNinetween[num - 11]);
        }
        if (num >= 20 || num == 10) {
            sb.append(tens[num / 10]).append(' ');
            num %= 10;
        }
        if (num > 0) {
            sb.append(ones[num]).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1);
    }
}