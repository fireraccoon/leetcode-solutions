/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// @lc code=start
class RandomizedSet {

    Random random = new Random();

    List<Integer> array = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.putIfAbsent(val, array.size()) == null) {
            array.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        Integer index = map.remove(val);
        if (index == null) {
            return false;
        }
        int lastIndex = array.size() - 1;
        if (index < lastIndex) {
            int tail = array.get(lastIndex);
            array.set(index, tail);
            map.put(tail, index);
        }
        array.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

