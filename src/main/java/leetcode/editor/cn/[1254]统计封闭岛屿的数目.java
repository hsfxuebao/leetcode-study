package leetcode.editor.cn;

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 171 👎 0

/**
 * 统计封闭岛屿的数目
 *
 * @author hsfxuebao
 * 2022-12-31 13:03:56 
 */
class P1254_NumberOfClosedIslands{
    public static void main(String[] args) {
        Solution solution = new P1254_NumberOfClosedIslands().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int closedIsland(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            // 先把四周的陆地 被 海水淹没
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n-1);

            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m-1, j);
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            // 越界
            if (i < 0 || i >= grid.length
                    || j < 0 || j >= grid[0].length) {
                return;
            }
            // 如果是海水，直接返回
            if (grid[i][j] == 1) {
                return;
            }
            // 变成海水
            grid[i][j] = 1;
            // 上下左右 遍历
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
