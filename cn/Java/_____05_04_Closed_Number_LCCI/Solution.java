// @algorithm @lc id=100183 lang=java 
// @title closed-number-lcci
package _____05_04_Closed_Number_LCCI;
// @test(2)=[4,1]
// @test(5)=[6,3]
// @test(67)=[69,56]
// @test(124)=[143,122]
// @test(8901)=[8902,8899]
// @test(2147483647)=[-1,-1]
public class Solution {
    public int[] findClosedNumbers(int num) {
        return new int[] { getNext(num), getPrev(num) };
    }
    private int getNext(int num) {
        int bitZero = 0;
        int bitOneCount = 0;
        while (bitZero < Integer.SIZE - 1 && (num & 1 << bitZero) == 0) {
            bitZero++;
        }
        while (bitZero < Integer.SIZE - 1 && (num & 1 << bitZero) != 0) {
            bitZero++;
            bitOneCount++;
        }
        if (bitZero == Integer.SIZE - 1) {
            return -1;
        }
        num |= 1 << bitZero;
        num &= ~((1 << bitZero) - 1);
        num |= (1 << (bitOneCount - 1)) - 1;
        return num;
    }
    private int getPrev(int num) {
        int bitOne = 0;
        int bitOneCount = 0;
        while (bitOne < Integer.SIZE - 1 && (num & 1 << bitOne) != 0) {
            bitOne++;
            bitOneCount++;
        }
        while (bitOne < Integer.SIZE - 1 && (num & 1 << bitOne) == 0) {
            bitOne++;
        }
        if (bitOne == Integer.SIZE - 1) {
            return -1;
        }
        num ^= 1 << bitOne;
        num &= ~((1 << bitOne) - 1);
        num |= (1 << (bitOneCount + 1)) - 1 << bitOne - bitOneCount - 1;
        return num;
    }
}