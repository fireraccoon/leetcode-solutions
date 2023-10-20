/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class StockSpanner {

    int day = 0;

    Deque<PriceWithDay> stack = new LinkedList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        int ans = stack.isEmpty() ? day + 1 : day - stack.peek().day;
        stack.push(new PriceWithDay(day, price));
        day++;
        return ans; 
    }

    private class PriceWithDay {

        public int price, day;

        public PriceWithDay(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

