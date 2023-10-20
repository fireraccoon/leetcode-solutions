/*
 * @lc app=leetcode.cn id=381 lang=java
 *
 * [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// @lc code=start
class RandomizedCollection {

    Random random = new Random();

    List<Integer> array = new ArrayList<>();

    Map<Integer, Set<Integer>> map = new HashMap<>();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {
        Set<Integer> indices = map.get(val);
        boolean existed = indices != null;
        if (!existed) {
            indices = new HashSet<>();
            map.put(val, indices);
        }
        indices.add(array.size());
        array.add(val);
        return !existed;
    }

    public boolean remove(int val) {
        Set<Integer> indices = map.get(val);
        if (indices == null) {
            return false;
        }
        int lastIndex = array.size() - 1;
        int index = indices.iterator().next();
        indices.remove(index);
        if (indices.isEmpty()) {
            map.remove(val);
        }
        if (index < lastIndex) {
            int tail = array.get(lastIndex);
            array.set(index, tail);
            indices = map.get(tail);
            indices.add(index);
            indices.remove(lastIndex);
        }
        array.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

