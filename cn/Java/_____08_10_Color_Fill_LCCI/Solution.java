// @algorithm @lc id=100201 lang=java 
// @title color-fill-lcci
package _____08_10_Color_Fill_LCCI;
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor != image[sr][sc]) {
            dfs(image, newColor, image[sr][sc], sr, sc);
        }
        return image;
    }
    void dfs(int[][] image, int newColor, int oldColor, int x, int y) {
        image[x][y] = newColor;
        if (x > 0 && image[x - 1][y] == oldColor) {
            dfs(image, newColor, oldColor, x - 1, y);
        }
        if (y > 0 && image[x][y - 1] == oldColor) {
            dfs(image, newColor, oldColor, x, y - 1);
        }
        if (x + 1 < image.length && image[x + 1][y] == oldColor) {
            dfs(image, newColor, oldColor, x + 1, y);
        }
        if (y + 1 < image[0].length && image[x][y + 1] == oldColor) {
            dfs(image, newColor, oldColor, x, y + 1);
        }
    }
}