package leetcode.editor.cn;

//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 191 👎 0

/**
 * 飞地的数量
 *
 * @author hsfxuebao
 * 2022-12-31 12:59:02 
 */
class P1020_NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new P1020_NumberOfEnclaves().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // 先把上下左右的岛屿淹没，不符合封闭岛屿的条件
        for (int i = 0; i < m; i++) {
            // 左边
            dfs(grid, i, 0);
            // 右边
            dfs(grid, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            // 上边
            dfs(grid, 0, j);
            // 下边
            dfs(grid, m-1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    // 把周边岛屿也变成海水
                    res += dfs(grid, i, j);
                }
            }
        }
        return res;

    }

        private int dfs(int[][] grid, int i, int j) {
            // 越界
            if (i < 0 || i >= grid.length
                    || j < 0 || j >= grid[0].length) {
                return 0;
            }
            // 如果是海水，直接返回
            if (grid[i][j] == 0) {
                return 0;
            }
            // 变成海水
            grid[i][j] = 0;
            // 上下左右 遍历
            return dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j-1)
                + dfs(grid, i, j+1) + 1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
