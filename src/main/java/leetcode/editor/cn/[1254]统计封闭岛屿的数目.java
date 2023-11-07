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

            int row = grid.length;
            int col = grid[0].length;


            // 先淹没四周
            // 左边的第一列
            for (int i = 0; i < row; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, col-1);
            }

            // 第一行
            for (int j = 0; j < col; j++) {
                dfs(grid, 0, j);
                dfs(grid, row-1, j);

            }

            int count = 0;
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            // 当前位置是海水
            if (grid[i][j] == 1) {
                return;
            }
            grid[i][j] = 1;
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);

        }


    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
