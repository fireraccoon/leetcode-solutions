# math collection

1. 裴蜀定理（贝祖定理）

    设 $a,b$ 是不全为零的整数，则存在整数 $x,y$，使得 $ax+by=\gcd(a,b)$.

2. 拉格朗日四平方和定理

    任何一个正整数都可以表示成四个整数的平方之和。

## [70.爬楼梯](../src/70.爬楼梯_3.java)

类似 $a_n=a_{n-i}+...+a_{n-1}$ 的数列求通项公式
斐波那契数列
$$f(n)=f(n-1)+f(n-2)
$$转化为 $a_n+r*a_{n-1}=k*(a_{n-1}+r*a_{n-2})$
$$
  \left\{
    \begin{aligned}
      k-r&=1\\
      k*r&=1
    \end{aligned}
  \right.
$$解得：$k=\frac{\sqrt{5}+1}{2},r=\frac{\sqrt{5}-1}{2}$
$$
  \left\{
    \begin{aligned}
      g(n)&=f(n)+\frac{\sqrt{5}-1}{2}*f(n-1)\\
      g(n)&=k*g(n-1)=(\frac{\sqrt{5}+1}{2})^{n-1}*g(1)
    \end{aligned}
  \right.
$$即
$$f(n)+\frac{\sqrt{5}-1}{2}*f(n-1)=(\frac{\sqrt{5}+1}{2})^{n-1}
$$转化为 $a_n+s*(\frac{\sqrt{5}+1}{2})^n=-t*(a_{n-1}+s*(\frac{\sqrt{5}+1}{2})^{n-1})$
$$
  \left\{
    \begin{aligned}
      -t&=-\frac{\sqrt{5}-1}{2}\\
      -(t+\frac{\sqrt{5}+1}{2})*s&=1
    \end{aligned}
  \right.
$$解得：$t=\frac{\sqrt{5}-1}{2},s=-\frac{\sqrt{5}}{5}$
故有
$$
  \left\{
    \begin{aligned}
      h(n)&=f(n)-\frac{\sqrt{5}}{5}*(\frac{\sqrt{5}+1}{2})^n\\
      h(n)&=-t*h(n-1)=(\frac{1-\sqrt{5}}{2})^{n-1}*h(1)
    \end{aligned}
  \right.
$$即$$
  f(n)=\frac{1}{\sqrt{5}}*((\frac{1+\sqrt{5}}{2})^n-(\frac{1-\sqrt{5}}{2})^n)$$

## [89.格雷编码](../src/89.格雷编码.java)

$$G(n)=n\oplus\lfloor\frac{n}{2}\rfloor$$

## [96.不同的二叉搜索树](../src/96.不同的二叉搜索树.java)

$$G(n)=\sum\limits_{i=1}^n G(i-1) \cdot G(n-i)$$$$
Catalan(n)=C^n_{2n}-C_{2n}^{n+1}=\frac{1}{n+1}C^n_{2n}$$$$
Catalan(n+1)=\frac{1}{n+2}C^{n+1}_{2n+2}=\frac{4n+2}{n+2}Catalan(n)$$

## [119.杨辉三角-ii](../src/119.杨辉三角-ii.java)

杨辉三角对应 $(a+b)^n$ 展开式的各项系数，即第 $n$ 行的第 $m$ 个数对应组合数 $C^m_n (n\geq0,m\geq0)$。

$$
\begin{aligned}
C^m_n&=\frac{n!}{m!(n-m)!}\\&=C^{m-1}_n*\frac{n-m+1}{m}
\end{aligned}
$$

## [136.只出现一次的数字](../src/136.只出现一次的数字.java)

异或运算满足交换律和结合律。
$$b\oplus a\oplus b=a\oplus b\oplus b=a\oplus(b\oplus b)=a$$

## 137.只出现一次的数字-ii

1. [单独考虑每一位](../src/137.只出现一次的数字-ii_1.java)

    考虑每个数的二进制表示，对于每一位，如果出现 1 的次数不是 3 的倍数，则答案中这一位为 1，否则为 0。

2. [数字电路](../src/137.只出现一次的数字-ii.java)

    二进制一个位只能表示 0 或 1，不能表示 2，这些信息可以根据真值表放入两个记录数 a，b。

    具体地，用 ab 的 00 表示 0，01 表示 1，10 表示 2。

    | a | b | x | a' | b' |
    | - | - | - | - | - |
    | 0 | 0 | 0 | 0 | 0 |
    | 0 | 1 | 0 | 0 | 1 |
    | 1 | 0 | 0 | 1 | 0 |
    | 0 | 0 | 1 | 0 | 1 |
    | 0 | 1 | 1 | 1 | 0 |
    | 1 | 0 | 1 | 0 | 0 |

    根据真值表可设计出电路：

    $$a'=a\bar b\bar x+\bar abx
    \\b'=\bar ab\bar x+\bar a\bar bx=\bar a(b\oplus x)$$

## [168.Excel表列名称](../src/168.Excel表列名称.java)

数制转换偏移问题（以二进制为例）。

设有映射 $f(n)：1\rightarrow A，2\rightarrow B$。

| 十进制 | 二进制 | 解空间映射 | 解空间映射转化 |
| - | - | - | - |
| 1 | 1 | A | 0' |
| 2 | 10 | B | 1' |
| 3 | 11 | BA | 1'0' |
| 4 | 100 | BB | 1'1' |

问题转为：转为二进制，二进制减 1，0 变 A，1 变 B。

对于乘除运算，原来是满 1 进 1，现在是满 2 进 1；进行 % 运算前需要将值 -1，消除这一影响。

## [169.多数元素](../src/169.多数元素.java)

Boyer-Moore 投票算法。

对于当前遍历的数，如果与候选数相同，则计数器 +1，否则 -1。当计数器为 0 时，更换候选数。

当计数器为 0，说明当前候选数已经不占优势，候选数被新的数取代。

如果候选数为众数，要么在整个过程计数值 > 0；要么被取代后，后面的某个位置又取代了原来的候选数。

## [172.阶乘后的零](../src/172.阶乘后的零.java)

转化为求 $[1,n]$ 中质因子 5 的个数。可根据 $n$ 的 $k$ 幂累计贡献次数。

例如：$100=5*5*4$，贡献了 2 次（$k=2$），$[1,100]$ 中 $5^2$ 贡献了 $\frac{100}{5^2}$ 次；$[1,100]$ 中 $5^1$ 贡献了 $\frac{100}{5^1}$ 次。故题目转化为求值 $\sum\limits_{i=1}^{k}\frac{n}{5^i}，5\le5^k\le n$。

## 189.轮转数组

1. [环状替换](../src/189.轮转数组.java)

    从第一个元素开始，每次将当前元素放到正确的位置，直到回到起始位置。

    <img alt="举例k=2，n=6" src="https://pic.leetcode-cn.com/f0493a97cdb7bc46b37306ca14e555451496f9f9c21effcad8517a81a26f30d6-image.png" width="400"/>

    设每轮需要进行 $a$ 圈才能走完，每轮完成 $b$ 个元素的替换，则有 $an=bk$。由于一次遍历（尽可能少）即返回起始位置，$a=\frac{k}{\gcd(n,k)}$，$b=\frac{n}{\gcd(n,k)}$，需要进行的轮次 $c=\frac{n}{b}=gcd(n,k)$。

2. [数组翻转](../src/189.轮转数组_1.java)

    先反转整个数组，再分别反转前 k 个元素和后 n-k 个元素。

## [202.快乐数](../src/202.快乐数.java)

每一位数的最大数字的下一位数如下表。

| Digits | Largest | Next |
| :-: | :-: | :-: |
| 1 | 9 | 81 |
| 2 | 99 | 162 |
| 3 | 999 | 243 |
| 4 | 9999 | 324 |
| 13 | 9999999999999 | 1053 |

对于 $3$ 位数的数字，它不可能大于 $243$。这意味着它要么被困在 $243$ 以下的循环内，要么跌到 $1$。$4$ 位或 $4$ 位以上的数字在每一步都会丢失一位，直到降到 $3$ 位为止。

在 $[1,243]$ 的数中，只有一个循环 $4\rightarrow 16\rightarrow 37\rightarrow 58\rightarrow 89\rightarrow 145\rightarrow 42\rightarrow 20\rightarrow 4$。

## 204.计数质数

1. [埃氏筛](../src/204.计数质数_1.java)

    时间复杂度 $O(n\log\log n)$，空间复杂度 $O(n)$。

    如果 $x$ 是质数，那么大于 $x$ 的 $x$ 的倍数 $2x,3x,\ldots$ 一定不是质数。

    设 $\textit{isPrime}[i]$ 表示数 $i$ 是不是质数，如果是质数则为 $1$，否则为 $0$。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 $0$，这样在运行结束的时候我们即能知道质数的个数。

    实际上可以直接从 $x\cdot x$ 开始标记，因为 $2x,3x,\ldots$ 这些数一定在 $x$ 之前就被其他数的倍数标记过了，例如 $2$ 的所有倍数，$3$ 的所有倍数等。

2. [线性筛](../src/204.计数质数.java)

    时间复杂度 $O(n)$，空间复杂度 $O(n)$。

    相较于埃氏筛，我们多维护一个 $\textit{primes}$ 数组表示当前得到的质数集合。我们从小到大遍历，如果当前的数 $x$ 是质数，就将其加入 $\textit{primes}$ 数组。

    另一点与埃氏筛不同的是，「标记过程」不再仅当 $x$ 为质数时才进行，而是对每个整数 $x$ 都进行。对于整数 $x$，我们不再标记其所有的倍数 $x\cdot x,x\cdot (x+1),\ldots$，而是只标记质数集合中的数与 $x$ 相乘的数，即 $x\cdot\textit{primes}_0,x\cdot\textit{primes}_1,\ldots$ ，且在发现 $x\bmod \textit{primes}_i=0$ 的时候结束当前标记。

    核心点在于：如果 $x$ 可以被 $\textit{primes}_i$ 整除，那么对于合数 $y=x\cdot \textit{primes}_{i+1}$ 而言，它一定在后面遍历到 $\frac{x}{\textit{primes}_i}\cdot\textit{primes}_{i+1}$ 这个数的时候会被标记，其他同理，这保证了每个合数只会被其「最小的质因数」筛去，即每个合数被标记一次。

## [223.矩形面积](../src/223.矩形面积.java)

两个矩形的面积和减去重叠部分的面积。

## [229.多数元素-ii](../src/229.多数元素-ii.java)

Boyer-Moore 投票算法。

## [231.2的幂](../src/231.2-的幂.java)

$[1,2^{31}-1]$ 区间中的数 $2^k(0\le k\le30，k为整数)$ 一定是 $2^{30}$ 的因数。

## [258.各位相加](../src/258.各位相加.java)

```sh
原数: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
数根: 1 2 3 4 5 6 7 8 9  1  2  3  4  5  6  7  8  9  1  2  3  4  5  6  7  8  9  1  2  3 
```

可以发现数根从 $1$ 开始，周期为 $9$。对于自然数 $n$，数根为 $$(n-1)\textit{rem}\space 9+1$$

证明：假设整数 $\textit{num}$ 的十进制表示有 $n$ 位，从最低位到最高位依次是 $a_0$ 到 $a_{n-1}$，则 $\textit{num}$ 可以写成如下形式：
$$\begin{aligned}
  \textit{num} &= \sum_{i = 0}^{n - 1} a_i \times 10^i \\
  &= \sum_{i = 0}^{n - 1} a_i \times (10^i - 1 + 1) \\
  &= \sum_{i = 0}^{n - 1} a_i \times (10^i - 1) + \sum_{i = 0}^{n - 1} a_i \end{aligned}$$

- $\textit{num}$ 不是 $9$ 的倍数时，其数根即为 $\textit{num}$ 除以 $9$ 的余数。

- $\textit{num}$ 是 $9$ 的倍数时：

  - 如果 $\textit{num}=0$，则其数根是 $0$；

  - 如果 $\textit{num}>0$，则各位相加的结果大于 $0$，其数根也大于 $0$，因此其数根是 $9$。

故可以发现，当 $n>0$，数根从 $1$ 开始，周期为 $9$。

## [260.只出现一次的数字-iii](../src/260.只出现一次的数字-iii.java)

设结果为 ${a,b}$，则只需要根据 $a$ 和 $b$ 不同的某一位即可把数分成两组，在各组中求解只出现一次的数字。

具体来说，先利用 [136.只出现一次的数字](../src/136.只出现一次的数字.java) 的原理求出 $a\oplus b$，然后利用 $(a\oplus b)\And -(a\oplus b)$ 求出 $a\oplus b$ 的最后一位 $1$ 作为掩码即可把数分成两组，分别求解即可。

## [268.丢失的数字](../src/268.丢失的数字.java)

1. [构造异或](../src/268.丢失的数字_1.java)

    利用异或性质 $a\oplus b\oplus a=b$，构造 $[0,n]$ 的异或结果 $a$，再与数组中的每个数异或，最后的结果即为缺失的数字。

2. [数列求和](../src/268.丢失的数字.java)

    对 $a_0=0$，$d=1$ 的等差数列 $a_n$ 求和，减去数组的和。

## [279.完全平方数](../src/279.完全平方数.java)

四平方和定理包含了一个更强的结论：当且仅当 $n\neq 4^k\times(8m+7)$ 时，$n$ 可以被表示为至多三个正整数的平方和。

- 利用 $n=4^k\times(8m+7)$ 排除 $4$。

- 利用 $a*a=n$ 排除 $1$。

- 利用 $a*a+b*b=n$ 排除 $2$。

- 剩余答案为 $3$。

## 287.寻找重复数

1. [位统计](../src/287.寻找重复数_1.java)

    对于每一位，分别计算 $[1,n]$ 和数组中该位为 $1$ 的个数 $x$ 及 $y$，如果 $x<y$，则该位为 $1$，否则为 $0$。

2. [Floyd判圈法](../src/287.寻找重复数.java)

    构造圈：$i\rightarrow\textit{nums}[i]\rightarrow\textit{nums}[\textit{nums}[i]]\rightarrow\cdots$。

    由于数组存在重复元素，故一定存在环，且环的入口即为重复元素。利用 Floyd 判圈法可以找到环的入口。

## [292.Nim 游戏](../src/292.nim-游戏.java)

| n | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | ... |
| - | - | - | - | - | - | - | - | - | - |
| 结果 | 赢 | 赢 | 赢 | 输 | 赢 | 赢 | 赢 | 输 | ... |

周期为 $4$，$n\%4=0$ 时输。

## [371.两整数之和](../src/371.两整数之和.java)

| $a$ | $b$ | $c_i$ | $s$ |
| --- | --- | --- | --- |
| $0$ | $0$ | $0$ | $0$ |
| $0$ | $1$ | $0$ | $1$ |
| $1$ | $0$ | $0$ | $1$ |
| $1$ | $1$ | $1$ | $0$ |

$c_i=a\&b，s=a\oplus b$

## 509.斐波那契数

1. [矩阵快速幂](../src/509.斐波那契数_1.java)

    $$f(n)=\left\{\begin{aligned}
      & 0，& n=0 \\
      & 1，& n=1 \\
      & f(n-1)+f(n-2)，& n\geq2 \\
    \end{aligned}\right.$$

    $$\left[\begin{matrix} f(n) \\ f(n-1)\end{matrix}\right]=\left[\begin{matrix} 1 &1 \\ 1 &0\end{matrix}\right]\left[\begin{matrix} f(n-1) \\ f(n-2) \end{matrix}\right]$$

    $$\left[\begin{matrix} f(n+1) \\ f(n)\end{matrix}\right]=\left[\begin{matrix} 1 &1 \\ 1 &0\end{matrix}\right]^n\left[\begin{matrix} f(1) \\ f(0) \end{matrix}\right]$$

2. [通项公式](../src/509.斐波那契数.java)

    $$f(n)=\frac{1}{\sqrt{5}}*((\frac{1+\sqrt{5}}{2})^n-(\frac{1-\sqrt{5}}{2})^n)$$

    推导见 [70.爬楼梯](../src/70.爬楼梯_3.java)

## [790.多米诺和托米诺平铺](../src/790.多米诺和托米诺平铺.java)

$$f(n)=\left\{\begin{aligned}
    & 1, & n=0或n=1 \\
    & 2, & n=2 \\
    & f(n-1)+f(n-2)+(f(n-3)+\cdots+f(0))\times2, & n\geq3
\end{aligned}\right.$$

$$f(n)=f(n-1)+f(n-2)+(f(n-3)+\cdots+f(0))\times2\cdots\cdots(1)\\
f(n-1)=f(n-2)+f(n-3)+(f(n-4)+\cdots+f(0))\times2\cdots\cdots(2) \\
(1)-(2)：f(n)-f(n-1)=f(n-1)+f(n-3)$$

整理得：

$$f(n)=\left\{\begin{aligned}
    & 1, & n=0或n=1 \\
    & 2, & n=2 \\
    & f(n-1)\times2+f(n-3), & n\geq3
\end{aligned}\right.$$

递推关系：

$$\left[ \begin{matrix} f(n) \\ f(n-1) \\ f(n-2) \end{matrix} \right] = \left[ \begin{matrix} 2 & 0 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right] \left[ \begin{matrix} f(n-1) \\ f(n-2) \\ f(n-3) \end{matrix} \right]$$

因此：

$$\left[ \begin{matrix} f(n+2) \\ f(n+1) \\ f(n) \end{matrix} \right] = \left[ \begin{matrix} 2 & 0 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right]^n \left[ \begin{matrix} f(2) \\ f(1) \\ f(0) \end{matrix} \right]$$

令：

$$M = \left[ \begin{matrix} 2 & 0 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right]$$

用快速幂算法来加速 $M^n$ 的求取。

## 1071.字符串的最大公因子

1. [枚举最大前缀](../src/1071.字符串的最大公因子_2.java)

    - 时间复杂度：$O(\min(m,n)\times max(m,n))$。其中 $m$ 为 $str1$ 的长度，$n$ 为 $str2$ 的长度。

    - 空间复杂度：$O(\min(m,n))$。

2. [利用辗转相除法优化](../src/1071.字符串的最大公因子_1.java)

    对于 $str1$ 和 $str2$ 两者长度的最大公因数 $k=\gcd(|str1|，|str2|)$，可知字符串的最大公因子长度 $g$ 范围在 $[0,k]$；如果 $g$ 在 $[1,k-1]$，则实际上可以继续扩展长度到 $k$，此时并不是字符串的最大公因子。因此，我们只需要判断 $k$ 长度的前缀子串是否是字符串的公因子即可。

    - 时间复杂度：$O(\max(m,n))$。其中 $m$ 为 $str1$ 的长度，$n$ 为 $str2$ 的长度。

    - 空间复杂度：$O(\min(m,n))$。

3. [提前判定+辗转相除](../src/1071.字符串的最大公因子.java)

    如果字符串的最大公因子不为空，则易知 $(str1||str2)=(str2||str1)$ 一定会相等。故可提前判断是否存在最大公因子，并使用 2. 的方法求出最大公因子。

    - 时间复杂度：$O(m+n)$。其中 $m$ 为 $str1$ 的长度，$n$ 为 $str2$ 的长度。

    - 空间复杂度：$O(m+n)$。

## [1137.第 N 个泰波那契数](../src/1137.第-n-个泰波那契数.java)

递推关系：

$$\left[ \begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right] \left[ \begin{matrix} T(n) \\ T(n - 1) \\ T(n - 2) \end{matrix} \right] = \left[ \begin{matrix} T(n) + T(n - 1) + T(n - 2) \\ T(n) \\ T(n - 1) \end{matrix} \right] = \left[ \begin{matrix} T(n + 1) \\ T(n) \\ T(n - 1) \end{matrix} \right]$$

因此：

$$\left[ \begin{matrix} T(n + 2) \\ T(n + 1) \\ T(n) \end{matrix} \right] = \left[ \begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right]^n \left[ \begin{matrix} T(2) \\ T(1) \\ T(0) \end{matrix} \right]$$

令：

$$M = \left[ \begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right]$$

用快速幂算法来加速 $M^n$ 的求取。

## [1318.或运算的最小翻转次数](../src/1318.或运算的最小翻转次数.java)

设 $x=a\vee b$，$y=x\oplus c$ 求得 $x$ 与 $c$ 不一致的位数，此时计算 $x$ 中 $1$ 的个数可以得到 $x$ 到 $c$ 的翻转次数。对于 $a$ 和 $b$ 中都为 $1$，$c$ 中为 $0$ 的二进制位，实际上翻转 $a$ 和 $b$ 要进行 $2$ 次，而翻转 $x$ 只计算了 $1$ 次。

通过以上分析，最终结果还要加上 $a$ 和 $b$ 中都为 $1$，$c$ 中为 $0$ 的二进制位数。只需计算 $a\wedge b\wedge\sim c$ 中 $1$ 的个数即可。

## [面试题 05.04. 下一个数](../cn/Java/_____05_04_Closed_Number_LCCI/Solution.java)

下一个大的数：找到最右边的后面跟着 $1$ 的 $0$，将其置 $1$，并将其右边原有的 $1$ 数量减 $1$ 并全部移动的最右边。

下一个小的数：找到最右边的后面跟着 $0$ 的 $1$，将其置 $0$，并将其右边原有的 $1$ 数量减 $1$ 并全部移动到翻转位的右边。

## [面试题 08.01. 三步问题](../cn/Java/_____08_01_Three_Steps_Problem_LCCI/Solution.java)

$$f(n)=\left\{\begin{aligned}
  & 1, & n=0或n=1 \\
  & 2, & n=2 \\
  & f(n-1)+f(n-2)+f(n-3), & n\ge3
\end{aligned}\right.$$

$$\left[\begin{matrix} f(n) \\ f(n-1) \\ f(n-2) \end{matrix}\right]=\left[\begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix}\right]\left[\begin{matrix} f(n-1) \\ f(n-2) \\ f(n-3) \end{matrix}\right]$$

故有：

$$\left[\begin{matrix} f(n+2) \\ f(n+1) \\ f(n) \end{matrix}\right]=\left[\begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix}\right]^n\left[\begin{matrix} f(2) \\ f(1) \\ f(0) \end{matrix}\right]$$

令：

$$M = \left[ \begin{matrix} 1 & 1 & 1 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{matrix} \right]$$

用快速幂算法来加速 $M^n$ 的求取。

## [面试题 08.11. 硬币](../cn/Java/_____08_11_Coin_LCCI/Solution.java)

首先枚举 $25$ 分硬币的个数 $i_{25}$，剩余的金额为 $rest_{25}=n-25*i_{25}$。

此时 $10$ 分硬币可取最大的个数为 $max_{10}=\lfloor\frac{rest_{25}}{10}\rfloor$，此时剩余金额为 $rest_{10}=rest_{25}-10\times max_{10}$。

此时 $5$ 分硬币可取最大的个数为 $max_5=\lfloor\frac{rest_{10}}{5}\rfloor$，此时剩余给 $1$ 分的金额为 $rest_5=rest_{10}-5\times max_5$。

因此，若我们取 $i_{25}$ 个 $25$ 分硬币，$i_{10}$ 个 $10$ 分硬币，剩余的金额为 $$10\times(max_{10}-i_{10})+5\times max_5+rest_5$$

即 $$5\times(2\times max_{10}-2\times i_{10}+max_5)+rest_5$$

从该式子可以得到此时 $5$ 分硬币的个数为 $$i_5=2\times max_{10}-2\times i_{10}+max_5$$

由于 $rest_{25}$ 可以取任意值，故 $i_5$ 的取值范围为 $[0,2\times max_{10}-2\times i_{10}+max_5]$，即方案数有 $2\times max_{10}-2\times i_{10}+max_5+1$。

也就是说取 $i_{25}$ 个 $25$ 分硬币，$i_{10}$ 个 $10$ 分硬币时，方案数有 $2\times max_{10}-2\times i_{10}+max_5+1$。

故可以枚举 $i_{25}$，计算 $$\sum_{i_{10}=0}^{max_{10}}(2\times max_{10}-2\times i_{10}+max_5+1)$$

利用等差求和即可在 $O(1)$ 时间复杂度下算出每个 $i_{25}$ 对应地方案数量。

## [面试题 16.03. 交点](../cn/Java/_____16_03_Intersection_LCCI/Solution.java)

求直线方程 $y=k\times x+b$，其中 $k=\frac{y_2-y_1}{x_2-x_1}$，$b=y_1-k\times x_1$，对斜率 $k$分类讨论。

## [面试题 16.05. 阶乘尾数](../cn/Java/_____16_05_Factorial_Zeros_LCCI/Solution.java)

同 [172.阶乘后的零](../src/172.阶乘后的零.java)。

## [面试题 16.07. 最大数值](../cn/Java/_____16_07_Maximum_LCCI/Solution.java)

## [面试题 16.11. 跳水板](../cn/Java/_____16_11_Diving_Board_LCCI/Solution.java)

从可以拼成的最短木板开始，每次加长 $longer-shorter$，进行 $k$ 次。

## [面试题 16.13. 平分正方形](../cn/Java/_____16_13_Bisect_Squares_LCCI/Solution.java)

直线上两点可构成直线的参数方程：

$$\left\{\begin{aligned}
  x &= x_1+t\cdot(x_1-x_2) \\
  y &= y_1+t\cdot(y_1-y_2)
\end{aligned}\right.$$

已知 $y$，则 $x=(y-y_1)/(y_1-y_2)*(x_1-x_2)+x_1$；已知 $x$，则 $y=(x-x_1)/(x_1-x_2)*(y_1-y_2)+y_1$。

需要对 $x$ 和 $y$ 分别进行判断，因为 $x_1=x_2$ 或 $y_1=y_2$ 时，分母为 $0$。

## [面试题 16.14. 最佳直线](../cn/Java/_____16_14_Best_Line_LCCI/Solution.java)

求斜截式，做哈希。

## [面试题 16.18. 模式匹配](../cn/Java/_____16_18_Pattern_Matching_LCCI/Solution.java)

根据数学关系枚举两种代表字符的长度：

$$c_a*\ell_a+(\ell_p-c_a)*\ell_b=\ell_v$$

## 面试题 17.04. 消失的数字

1. [异或求丢失数字](../cn/Java/_____17_04_Missing_Number_LCCI_1/Solution.java)

2. [数列求和](../cn/Java/_____17_04_Missing_Number_LCCI_1/Solution.java)

## [面试题 17.06. 2出现的次数](../cn/Java/_____17_06_Number_Of_2s_In_Range_LCCI/Solution.java)

对于某位 $digit$，若 $digit\le2$，则该位贡献 $n$ 将 $digit$ 及其后所有位置置 $0$ 后的数除以 $10$；若 $digit=2$，则该位贡献 $n$ 将 $digit$ 及其后所有位置置 $0$ 后的数除以 $10$ 加上 $n$ 中 $digit$ 以后的数加 $1$ 的和；若 $digit\ge2$，则该位贡献离 $n$ 将 $digit$ 及其后所有位置置 $0$ 后的数除以 $10$ 最近的大于该数的后缀 $0$ 一致的数。

## [面试题 17.10. 主要元素](../cn/Java/_____17_10_Find_Majority_Element_LCCI/Solution.java)

Boyer-Moore 投票算法。

## [面试题 17.19. 消失的两个数字](../cn/Java/_____17_19_Missing_Two_LCCI/Solution.java)

找到 $a$ 和 $b$ 的某一位不同（即 $a^b$ 为 $1$ 的某一位），根据该位将数组分为两组，两组中各有一个缺失元素，此时可分别利用异或运算求解。
