// @algorithm @lc id=1000050 lang=java 
// @title langtons-ant-lcci
package _____16_22_Langtons_Ant_LCCI;
// @test(0)=["R"]
// @test(2)=["_X","LX"]
// @test(5)=["_U","X_","XX"]
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    private final static char[] TOWARDS_MAP = new char[] {
        'R', 'D', 'L', 'U'
    };
    private final static int[][] TOWARDS_ACTIONS = new int[][] {
        { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };
    public List<String> printKMoves(int K) {
        int towards = 0;
        Set<Coordinate> blackSet = new HashSet<>();
        Coordinate leftTop = new Coordinate(0, 0);
        Coordinate rightBottom = new Coordinate(0, 0);
        Coordinate position = new Coordinate(0, 0);
        while (K-- > 0) {
            boolean isInBlack = blackSet.remove(position);
            if (!isInBlack) {
                blackSet.add(new Coordinate(position));
            }
            towards = nextTowards(towards, isInBlack);
            move(position, towards);
            updateGridBound(position, leftTop, rightBottom);
        }
        return generateGrid(blackSet, position, leftTop, rightBottom, TOWARDS_MAP[towards]);
    }

    private List<String> generateGrid(Set<Coordinate> blackSet, Coordinate endPosition, Coordinate leftTop, Coordinate rightBottom, char towards) {
        int m = rightBottom.x - leftTop.x + 1, n = rightBottom.y - leftTop.y + 1;
        String[] grid = new String[m];
        Coordinate poistion = new Coordinate(leftTop);
        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                if (poistion.equals(endPosition)) {
                    row[j] = towards;
                } else {
                    row[j] = blackSet.contains(poistion) ? 'X' : '_';
                }
                poistion.y++;
            }
            poistion.x++;
            poistion.y = leftTop.y;
            grid[i] = new String(row);
        }
        return Arrays.asList(grid);
    }

    private void updateGridBound(Coordinate position, Coordinate leftTop, Coordinate rightBottom) {
        if (leftTop.x > position.x) {
            leftTop.x = position.x;
        } else if (leftTop.y > position.y) {
            leftTop.y = position.y;
        } else if (rightBottom.x < position.x) {
            rightBottom.x = position.x;
        } else if (rightBottom.y < position.y) {
            rightBottom.y = position.y;
        }
    }

    private int nextTowards(int towards, boolean isInBlack) {
        if (isInBlack) {
            return --towards < 0 ? 3 : towards;
        }
        return ++towards > 3 ? 0 : towards;
    }

    private void move(Coordinate position, int towards) {
        position.x += TOWARDS_ACTIONS[towards][0];
        position.y += TOWARDS_ACTIONS[towards][1];
    }

    private class Coordinate {

        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(Coordinate o) {
            this(o.x, o.y);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Coordinate) {
                Coordinate other = (Coordinate) o;
                return x == other.x && y == other.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}