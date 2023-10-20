# parse collection

## [394.字符串解码](../394.字符串解码.java)

**BNF** 文法如下：

$$\begin{aligned}
  String & \rightarrow Digits\, [String]\, String\mid Alpha\, String\mid \epsilon \\
  Digits & \rightarrow Digit\, Digits\mid Digit \\
  Alpha & \rightarrow a\mid\cdots\mid z\mid A\mid\cdots\mid Z \\
  Digit & \rightarrow 0\mid\cdots\mid 9
\end{aligned}$$

根据 FOLLOW 集构造预测分析表：

| | $Alpha$ | $Digits$ | $\epsilon$ |
| :-: | :-: | :-: | :-: |
| $String$ | $String \rightarrow Alpha \, String$ | $String \rightarrow Digits \, [String] \, String$ | $String \rightarrow \epsilon$ |

该文法为 **LL(1)** 文法，因此可以用递归下降分析法进行分析。
