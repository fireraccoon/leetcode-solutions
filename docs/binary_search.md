# binary search collection

## [33.搜索旋转排序数组](../src/33.搜索旋转排序数组.java)

## 50.pow-x-n

1. 空间 [O(log n)](../src/50.pow-x-n_1.java)
2. 空间 [O(n)](../src/50.pow-x-n_2.java)

## [69.x-的平方根](../src/69.x-的平方根.java)

## [70.爬楼梯](../src/70.爬楼梯_2.java)

齐次方程转化为矩阵形式
$$f(n)=f(n-1)+f(n-2)$$$$
  \begin{bmatrix}
    f(n)\\
    f(n-1)\\
  \end{bmatrix}=\begin{bmatrix}
    1 & 1\\
    1 & 0\\
  \end{bmatrix}*
  \begin{bmatrix}
    f(n-1)\\
    f(n-2)\\
  \end{bmatrix}
$$$$
  \left\{
    \begin{aligned}
      g(n)&=\begin{bmatrix}
        f(n)\\
        f(n-1)\\
      \end{bmatrix}\\
      g(n)&=\begin{bmatrix}
        1 & 1\\
        1 & 0\\
      \end{bmatrix}*g(n-1)
      =\begin{bmatrix}
        1 & 1\\
        1 & 0\\
      \end{bmatrix}^{n-1}*g(1)
    \end{aligned}
  \right.$$

## [74.搜索二维矩阵](../src/74.搜索二维矩阵.java)

## [81.搜索旋转排序数组-ii](../src/81.搜索旋转排序数组-ii.java)

## [153.寻找旋转排序数组中的最小值](../src/153.寻找旋转排序数组中的最小值.java)

## [154.寻找旋转排序数组中的最小值-ii](../src/154.寻找旋转排序数组中的最小值-ii.java)

## [162.寻找峰值](../src/162.寻找峰值.java)

问题具有二段性，可使用二分法。

## [209.长度最小的子数组](../src/209.长度最小的子数组_1.java)

根据前缀和进行二分查找。

## 222.完全二叉树的节点个数

1. [深搜+二分查找确定搜索方向](../src/222.完全二叉树的节点个数_1.java)

    - 时间复杂度：$O(\log n\times \log n)$。

    - 空间复杂度：$O(\log n)$，递归栈高度。

2. [二分查找+位运算](../src/222.完全二叉树的节点个数.java)

    - 时间复杂度：$O(\log n\times \log n)$。

    - 空间复杂度：$O(1)$。

## [230.二叉搜索树中第K小的元素](../src/230.二叉搜索树中第k小的元素_1.java)

`哈希表` + `二分查找`。

## [235.二叉搜索树的最近公共祖先](../src/235.二叉搜索树的最近公共祖先.java)

## 240.搜索二维矩阵-ii

1. [行内二分](../src/240.搜索二维矩阵-ii_2.java)

    - 时间复杂度：$O(m\log n)$。

    - 空间复杂度：$O(1)$。

2. [分治+二分](../src/240.搜索二维矩阵-ii_1.java)

    - 时间复杂度：$O(\min(m,n)\log\max(m,n))$。

    - 空间复杂度：$O(\log\min(m,n))$。

3. [Z字形搜索](../src/240.搜索二维矩阵-ii.java)

    - 时间复杂度：$O(m+n)$。

    - 空间复杂度：$O(1)$。

## [274.H 指数](../src/274.h-指数.java)

在范围 $[0,n]$ 内查找最大的 H 指数，对于每个候选值统计该值在数组中出现的次数，如果满足 H 指数条件，说明最大的 H 指数大于等于当前候选值，继续往右找，否则往左找。

## [275.H 指数 II](../src/275.h-指数-ii.java)

在范围 $[0,n]$ 内查找最大的 H 指数，如果当前候选值不满足 H 指数条件，说明最大的 H 指数大于当前候选值，继续往右找，否则往左找。

## [278.第一个错误的版本](../src/278.第一个错误的版本.java)

## [287.寻找重复数](../src/287.寻找重复数_2.java)

解区间为 $[1,n]$，对于每个候选值统计数组中小于等于该值的元素个数，如果个数大于该值，说明重复元素为当前值或者左半区间，否则在右半区间。

## [300.最长递增子序列](../src/300.最长递增子序列.java)

> **贪心** + **二分查找**

要使得结果数组尽可能长，需要元素之间的距离尽可能小。

通过维护一个单调递增数组，如果当前元素大于数组末尾元素，则插入数组；否则在数组中二分查找第一个大于等于当前元素的位置并将其替换。如此操作元素间的距离会不断缩小。

## [373.查找和最小的 K 对数字](../src/373.查找和最小的-k-对数字.java)

可以看作行递增且列递增的矩阵进行**二分查找**，找到最小的 $\textit{target}$ 且满足小于等于它的数对数目刚好大于等于 $k$ 即为目标值 $\textit{pairSum}$，然后利用两次**滑动窗口**在矩阵中找到最小的 $k$ 个数对满足数对和小于等于 $\textit{pairSum}$。

- 时间复杂度：$O(k+(m+n)\times\log(diff(nums_1)+diff(nums_2)))$。其中 $m,n$ 表示数组 $\textit{nums}_1,\textit{nums}_2$ 的长度，$\textit{diff}(arr)$ 表示数组 $arr$ 中最大元素与最小元素之差。

- 空间复杂度：$O(1)$。

## [374.猜数字大小](../src/374.猜数字大小.java)

## [704.二分查找](../src/704.二分查找.java)

## [875.爱吃香蕉的珂珂](../src/875.爱吃香蕉的珂珂.java)

## [1004.最大连续1的个数 III](../src/1004.最大连续-1-的个数-iii_1.java)

`前缀和` + `二分查找`。

## [1268.搜索推荐系统](../src/1268.搜索推荐系统.java)

`排序` + `二分查找`。

## [2300.咒语和药水的成功对数](../src/2300.咒语和药水的成功对数.java)

`排序` + `二分`。

## [面试题 10.05. 稀疏数组搜索](../cn/Java/_____10_05_Sparse_Array_Search_LCCI/Solution.java)

带空值的二分查找。

## [面试题 10.03. 搜索旋转数组](../cn/Java/_____10_03_Search_Rotate_Array_LCCI/Solution.java)

## [面试题 10.09. 排序矩阵查找](../cn/Java/_____10_09_Sorted_Matrix_Search_LCCI/Solution.java)

Z 字形搜索。

## [面试题 17.08. 马戏团人塔](../cn/Java/_____17_08_Circus_Tower_LCCI/Solution.java)

排序 + 对结果二分。
