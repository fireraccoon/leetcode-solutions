# random collection

## [169.多数元素](../src/169.多数元素_1.java)

设找到众数的次数为 $i$，则 $P(第\space i\space 次找到众数)=\frac{1}{2^i}$

找到众数的次数期望为 $E=\sum\limits_{i=1}^{\infty}i*\frac{1}{2^i}$

设 $S(n)=\sum\limits_{i=1}^{n}i*\frac{1}{2^i}$

$$2E=\sum\limits_{i=1}^{n}i*\frac{1}{2^{i-1}}\\2E-E=1+\sum\limits_{i=1}^{n-1}\frac{1}{2^{i}}-n*\frac{1}{2^{n}}=\frac{1-\frac{1}{2}^n}{1-\frac{1}{2}}-\frac{n}{2^{n}}=2-\frac{2+n}{2^n}$$

故 $E=\lim_{n\to\infty}(2-\frac{2+n}{2^n})=2$

随机查找的期望为常数，算法时间复杂度为 $O(n)$。
