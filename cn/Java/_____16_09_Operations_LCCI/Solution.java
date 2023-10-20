// @algorithm @lc id=100350 lang=java 
// @title operations-lcci
package _____16_09_Operations_LCCI;
class Operations {

    public Operations() {

    }

    public int minus(int a, int b) {
        return a + negate(b);
    }

    public int multiply(int a, int b) {
        int mul = 0;
        int initialDelta = b > 0 ? -1 : 1;
        int initialMultiplyDelta = b < 0 ? negate(a) : a;
        int multiplyDelta = initialMultiplyDelta, delta = initialDelta;
        while (b != 0) {
            if (isOverflow(b, b + delta)) {
                delta = initialDelta;
                multiplyDelta = initialMultiplyDelta;
            }
            b += delta;
            mul += multiplyDelta;
            delta += delta;
            multiplyDelta += multiplyDelta;
        }
        return mul;
    }

    public int divide(int a, int b) {
        int div = 0;
        int initialDelta = a > 0 == b > 0 ? 1 : -1;
        int initialDivideDelta = a > 0 == b > 0 ? negate(b) : b;
        int delta = initialDelta, divideDelta = initialDivideDelta;
        while (a != 0) {
            if (isOverflow(divideDelta, initialDivideDelta)
                || isOverflow(a, a + divideDelta)) {
                if (isOverflow(a, a + initialDivideDelta)) {
                    break;
                }
                delta = initialDelta;
                divideDelta = initialDivideDelta;
            }
            div += delta;
            a += divideDelta;
            delta += delta;
            divideDelta += divideDelta;
        }
        return div;
    }

    private int negate(int x) {
        int negation = 0;
        int initialDelta = x > 0 ? 1 : -1;
        int delta = initialDelta;
        while (x != 0) {
            if (isOverflow(x, x + delta)) {
                delta = initialDelta;
            }
            x += delta;
            negation += delta;
            delta += delta;
        }
        return negation;
    }

    private boolean isOverflow(int source, int target) {
        return target != 0 && target > 0 != source > 0;
    }
}

/**
 * Your Operations object will be instantiated and called as such:
 * Operations obj = new Operations();
 * int param_1 = obj.minus(a,b);
 * int param_2 = obj.multiply(a,b);
 * int param_3 = obj.divide(a,b);
 */