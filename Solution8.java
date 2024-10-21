package com.check_maven;

/**
 * @description:
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 */
public class Solution8 {
    public static void main(String[] args) {
        // 你的测试代码可以放在这里
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        Solution8 solution = new Solution8();
        int numIslands = solution.numIslands(grid);
        System.out.println("岛屿数量: " + numIslands);
    }

    /**
     * 深度优先搜索（DFS）函数，用于标记已经访问过的陆地格子
     * @param grid 二维网格
     * @param r 当前行索引
     * @param c 当前列索引
     */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 判断是否越界或者是否遇到水
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 将当前陆地格子标记为 '0'，表示已经访问过
        grid[r][c] = '0';

        // 深度优先搜索，上下左右四个方向
        dfs(grid, r - 1, c); // 上
        dfs(grid, r + 1, c); // 下
        dfs(grid, r, c - 1); // 左
        dfs(grid, r, c + 1); // 右
    }

    /**
     * 计算网格中岛屿的数量
     * @param grid 二维网格
     * @return 岛屿的数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        // 遍历整个网格
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                // 如果遇到陆地格子
                if (grid[r][c] == '1') {
                    // 统计岛屿数量
                    ++num_islands;
                    // 使用DFS将整个岛屿标记为已经访问过
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
