/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 */

// @lc code=start
class Solution {
    private String[] ones = new String[] {
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };
    private String[] tenToNineteen = new String[] {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private String[] tens = new String[] {
        "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"
    };
    private String[] bases = new String[] {
        "Thousand", "Million", "Billion"
    };
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int base = 1_000_000_000;
        for (int i = 0; i < 4; i++) {
            int baseOfHundred = num / base % 1_000;
            if (baseOfHundred > 0) {
                sb.append(handleHundred(baseOfHundred));
                if (i < 3) {
                    sb.append(bases[2 - i]);
                    sb.append(' ');
                }
            }
            base /= 1_000;
        }
        return sb.substring(0, sb.length() - 1);
    }
    StringBuilder handleHundred(int baseOfHundred) {
        StringBuilder sb = new StringBuilder();
        int bit = baseOfHundred / 100;
        if (bit != 0) {
            sb.append(ones[bit - 1]);
            sb.append(' ');
            sb.append(tens[8]);
            sb.append(' ');
        }
        bit = baseOfHundred / 10 % 10;
        if (bit > 1) {
            sb.append(tens[bit - 2]);
            sb.append(' ');
        } else if (bit == 1) {
            sb.append(tenToNineteen[baseOfHundred % 100 - 10]);
            sb.append(' ');
            return sb;
        }
        bit = baseOfHundred % 10;
        if (bit > 0) {
            sb.append(ones[bit - 1]);
            sb.append(' ');
        }
        return sb;
    }
}
// @lc code=end

