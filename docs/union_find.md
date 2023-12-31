# union find collection

对于初始的 $n$ 个集合，使用 `路径压缩` + `启发式合并/按秩合并` 的并查集算法的时间复杂度为 $O(n*\alpha(n))$；使用 `路径压缩` 的平均时间复杂度为 $O(n*\alpha(n))$，最坏为 $O(n*log(n))$；使用 `启发式合并/按秩合并` 的并查集算法的时间复杂度为 $O(n*log(n))$。空间复杂度均为 $O(n)$。

其中 $\alpha(x)$ 为反阿克曼函数（[Ackermann 函数](https://en.wikipedia.org/wiki/Ackermann_function)的反函数），当自变量 $x$ 的值在人类可观测的范围内（宇宙中粒子的数量）时，函数 $\alpha(x)$ 的值不会超过 $5$，因此也可以看成是常数时间复杂度。

## [200.岛屿数量](../src/200.岛屿数量.java)

## [399.除法求值](../src/399.除法求值.java)

带权并查集。合并时，权值代表路径该点对根节点比值的乘积贡献。路径压缩时将路径权值自根节点向叶子节点累积相乘。

## [547.省份数量](../src/547.省份数量.java)

## [面试题 16.19. 水域大小](../cn/Java/_____16_19_Pond_Sizes_LCCI/Solution.java)
