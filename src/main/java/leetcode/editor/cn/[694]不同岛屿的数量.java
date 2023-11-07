package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 不同岛屿的数量
 *
 * @author hsfxuebao
 * Created on 2022-12-31
 *
 * 给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 *
 * 请你计算这个网格中共有多少个形状不同的岛屿。
 * 两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
 */
class P694_numDistinctIslands {


    public static void main(String[] args) {

    }

    class Solution {

        /**
         * 需要记录 每个岛屿的形状，用上下左右 来记录
         * @param grid
         * @return
         */
        int numDistinctIslands(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            // 可去重
            HashSet<String> sets = new HashSet<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder sb = new StringBuilder();
                        dfs(grid, i, j, 999, sb);
                        sets.add(sb.toString());
                    }
                }
            }
            return sets.size();
        }

        private void dfs(int[][] grid, int i, int j, int dir, StringBuilder sb) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;

            sb.append(dir).append(",");
            // 上下左右
            dfs(grid, i-1, j, 1, sb);
            dfs(grid, i+1, j, 2, sb);
            dfs(grid, i, j-1, 3, sb);
            dfs(grid, i, j+1, 4, sb);
            sb.append(-dir).append(",");

        }

    }
}

