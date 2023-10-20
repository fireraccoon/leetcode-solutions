// @algorithm @lc id=1000027 lang=java 
// @title calculator-lcci
package _____16_26_Calculator_LCCI;
// @test("3+2*2")=7
// @test(" 3/2 ")=1
// @test(" 3+5 / 2 ")=5
public class Solution {
    public int calculate(String s) {
        int n = s.length();
        int ans = 0;
        int firstLevelResult = 1;
        char firstLevelOperation = '*';
        char secondLevelOperation = '+';
        for (int i = 0; i < n;) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (Character.isDigit(c)) {
                int number = c - '0';
                while (++i < n && Character.isDigit(c = s.charAt(i))) {
                    number = number * 10 + c - '0';
                }
                firstLevelResult = firstLevelCompute(firstLevelResult, number, firstLevelOperation);
            } else if (c == '-' || c == '+') {
                ans = secondLevelCompute(ans, firstLevelResult, secondLevelOperation);
                firstLevelResult = 1;
                firstLevelOperation = '*';
                secondLevelOperation = c;
                i++;
            } else {
                firstLevelOperation = c;
                i++;
            }
        }
        return secondLevelCompute(ans, firstLevelResult, secondLevelOperation);
    }
    private int firstLevelCompute(int x, int y, char operation) {
        return operation == '/' ? x / y : x * y;
    }
    private int secondLevelCompute(int x, int y, char operation) {
        return operation == '+' ? x + y : x - y;
    }
}