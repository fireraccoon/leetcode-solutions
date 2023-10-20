/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

import java.util.Iterator;

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<T> implements Iterator<T> {

    private T peek;

    private Iterator<T> iterator;

    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            peek = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T value = peek;
        peek = iterator.hasNext() ? iterator.next() : null;
        return value;
    }

    @Override
    public boolean hasNext() {
        return peek != null;
    }
}
// @lc code=end

