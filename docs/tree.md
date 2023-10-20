# tree collection

## [230.二叉搜索树中第K小的元素](../230.二叉搜索树中第k小的元素.java)

平衡二叉搜索树。

## 295.数据流的中位数

1. [平衡二叉树 + 搜索第 k 个元素](../295.数据流的中位数_3.java)

    - 时间复杂度：`addNum` 操作为 $O(\log n)$，`findMedian` 操作为 $O(\log n)$。

    - 空间复杂度：$O(n)$。

2. [平衡二叉树 + 双指针](../295.数据流的中位数_2.java)

    - 时间复杂度：`addNum` 操作为 $O(\log n)$，`findMedian` 操作为 $O(1)$。

    - 空间复杂度：$O(n)$。

3. [红黑树 + 双指针，模拟可重复的有序集合](../295.数据流的中位数.java)

    - 时间复杂度：`addNum` 操作为 $O(\log n)$，`findMedian` 操作为 $O(1)$。

    - 空间复杂度：$O(n)$。

## 307.区域和检索-数组可修改

1. [线段树](../307.区域和检索-数组可修改_2.java)

    - 时间复杂度：`NumArray` 为 $O(n)$，`update` 操作为 $O(\log n)$，`sumRange` 操作为 $O(\log n)$。

    - 空间复杂度：$O(n)$。

2. [数组模拟平衡二叉树](../307.区域和检索-数组可修改_1.java)

    - 时间复杂度：`NumArray` 为 $O(n)$，`update` 操作为 $O(\log n)$，`sumRange` 操作为 $O(\log n)$。

    - 空间复杂度：$O(n)$。

3. [树状数组](../307.区域和检索-数组可修改.java)

    - 时间复杂度：`NumArray` 为 $O(n)$，`update` 操作为 $O(\log n)$，`sumRange` 操作为 $O(\log n)$。

    - 空间复杂度：$O(n)$。

## [剑指 Offer 51. 数组中的逆序对](../cn/Java/____Offer_51__________LCOF_1/Solution.java)

> 离散化树状数组

先将数组离散为 $[0,n-1]$：先排序，然后用二分法找到排序后数的索引来代表原来数的值。

从后往前遍历，将每个离散数加入树状数组，然后查询小于当前数的个数。由于当前数在已经添加的数的左边，所以查询的是在其右边的小于该数的数的个数。

## [315.计算右侧小于当前元素的个数](../315.计算右侧小于当前元素的个数_1.java)

> 离散化树状数组

分析同 [剑指 Offer 51. 数组中的逆序对](../cn/Java/____Offer_51__________LCOF_1/Solution.java)。

## [450.删除二叉搜索树中的节点](../450.删除二叉搜索树中的节点.java)

## [700.二叉搜索树中的搜索](../700.二叉搜索树中的搜索.java)

## [1268.搜索推荐系统](../1268.搜索推荐系统_1.java)

`排序` + `字典树`。

## [面试题 04.02. 最小高度树](../cn/Java/_____04_02_Minimum_Height_Tree_LCCI/Solution.java)

## [面试题 04.06. 后继者](../cn/Java/_____04_06_Successor_LCCI/Solution.java)

## [面试题 10.05. 稀疏数组搜索](../cn/Java/_____10_05_Sparse_Array_Search_LCCI_2/Solution.java)

## 面试题 10.10. 数字流的秩

1. [TreeMap，时间复杂度 $O(n^2)$](../cn/Java/_____10_10_Rank_from_Stream_LCCI_1/Solution.java)

2. [AVL](../cn/Java/_____10_10_Rank_from_Stream_LCCI/Solution.java)

## [面试题 16.20. T9键盘](../cn/Java/_____16_20_T9_LCCI_1/Solution.java)

字典树 + 回溯。

## [面试题 17.13. 恢复空格](../cn/Java/_____17_13_Re_Space_LCCI/Solution.java)

字典树（字符串反向） + 动态规划。

## [面试题 17.17. 多次搜索](../cn/Java/_____17_17_Multi_Search_LCCI/Solution.java)

## 面试题 17.20. 连续中值

1. [平衡二叉树 + 双指针](../cn/Java/_____17_20_Continuous_Median_LCCI_2/Solution.java)

2. [红黑树 + 双指针](../cn/Java/_____17_20_Continuous_Median_LCCI_1/Solution.java)

## [面试题 17.25. 单词矩阵](../cn/Java/_____17_25_Word_Rectangle_LCCI/Solution.java)

利用字典树进行深搜的剪枝。由于最终的结果矩阵在解空间中可倒置存在，故可以从最大的可能矩阵长度开始深搜，最终只要在某个尽可能大的矩阵长度中找到解，即可结束深搜。
