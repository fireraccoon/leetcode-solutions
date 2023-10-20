// @algorithm @lc id=1000031 lang=java 
// @title boolean-evaluation-lcci
package _____08_14_Boolean_Evaluation_LCCI;
// @test("1^0|0|1",0)=2
// @test("0&0&0&1^1|0",1)=10
public class Solution {
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i += 2) {
            dp[i][i][s.charAt(i) - '0'] = 1;
        }
        for (int len = 3; len <= n; len += 2) {
            for (int start = 0, end = len - 1; end < n; start += 2, end += 2) {
                for (int split = start + 1; split < end; split += 2) {
                    char option = s.charAt(split);
                    int[] leftSubAns = dp[start][split - 1];
                    int[] rightSubAns = dp[split + 1][end];
                    if (option == '&') {
                        dp[start][end][0] += leftSubAns[0] * rightSubAns[0]
                            + leftSubAns[0] * rightSubAns[1] + leftSubAns[1] * rightSubAns[0];
                        dp[start][end][1] += leftSubAns[1] * rightSubAns[1];
                    } else if (option == '|') {
                        dp[start][end][0] += leftSubAns[0] * rightSubAns[0];
                        dp[start][end][1] += leftSubAns[1] * rightSubAns[1]
                            + leftSubAns[0] * rightSubAns[1] + leftSubAns[1] * rightSubAns[0];
                    } else {
                        dp[start][end][0] += leftSubAns[0] * rightSubAns[0]
                            + leftSubAns[1] * rightSubAns[1];
                        dp[start][end][1] += leftSubAns[0] * rightSubAns[1]
                            + leftSubAns[1] * rightSubAns[0];
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }
}