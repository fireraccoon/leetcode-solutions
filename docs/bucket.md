# bucket collection

## [164.最大间距](../src/164.最大间距.java)

数组 `nums` 中的最大间距

$$maxGap\ge\lceil\frac{max(nums)-min(nums)}{length(nums)-1}\rceil$$

将数组根据大小

$$d=\lfloor\frac{max(nums)-min(nums)}{length(nums)-1}\rfloor$$

分 $k$ 个桶，其中为

$$k=\frac{max(nums)-min(nums)}{d}+1$$

每个桶记录**最大值**和**最小值**，最大间距一定不在桶内，而在桶间，故只需计算**桶间的最大间距**即可。

- 时间复杂度：$O(n)$。

- 空间复杂度：$O(n)$。

## [220.存在重复元素-iii](../src/220.存在重复元素-iii.java)

对于元素 $x$，其影响的区间为 $[x-t,x+t]$。于是我们可以设定桶的大小为 $t+1$。如果两个元素同属一个桶，那么这两个元素必然符合条件。如果两个元素属于相邻桶，那么我们需要校验这两个元素是否差值不超过 $t$。

每个桶只可能出现一个元素，故可使用哈希表存储桶。

- 时间复杂度：$O(n)$。

- 空间复杂度：$O(k)$。
