/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int myAtoi(String s) {
        Automation automation = new Automation();
        for (int i = 0; i < s.length(); i++) {
            automation.next(s.charAt(i));
        }
        return (int)automation.getResult();
    }
}

class Automation {
    private int signal = 1; 
    private long result = 0;
    private String state = "start";
    private Map<String, String[]> states = new HashMap<>(){{
        put("start", new String[] {"start", "signal", "number", "end"});
        put("signal", new String[] {"end", "end", "number", "end"});
        put("number", new String[]{"end", "end", "number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};
    public void next(char c) {
        String nextState = this.states.get(this.state)[this.getcol(c)];
        if ("signal".equals(nextState)) {
            this.signal = c == '-' ? -1 : 1;
        } else if ("number".equals(nextState)) {
            this.result = this.result * 10 + (c - '0') * this.signal;
            if (this.result >= Integer.MAX_VALUE) {
                this.result = Integer.MAX_VALUE;
                this.state = "end";
                return;
            } else if (this.result <= Integer.MIN_VALUE) {
                this.result = Integer.MIN_VALUE;
                this.state = "end";
                return;
            }
        }
        this.state = nextState;
    }
    private int getcol(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '-' || c == '+') {
            return 1;
        } else if (c >= '0' && c <= '9') {
            return 2;
        } else {
            return 3;
        }
    }
    public long getResult() {
        return result;
    }
}
// @lc code=end

