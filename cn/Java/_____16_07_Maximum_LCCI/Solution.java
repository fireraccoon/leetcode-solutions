// @algorithm @lc id=100349 lang=java 
// @title maximum-lcci
package _____16_07_Maximum_LCCI;
// @test(1,2)=2
public class Solution {
    public int maximum(int a, int b) {
        int signalOfA = a >>> Integer.SIZE - 1;
        int signalOfB = b >>> Integer.SIZE - 1;
        int signalOfASubB = a - b >>> Integer.SIZE - 1;
        int useSignalOfA = signalOfA ^ signalOfB;
        int resultSignal = useSignalOfA * signalOfA + (1 - useSignalOfA) * signalOfASubB;
        return (1 - resultSignal) * a + resultSignal * b;
    }
}