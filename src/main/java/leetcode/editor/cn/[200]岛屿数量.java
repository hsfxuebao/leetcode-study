package leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2346, 👎 0 
//
//
//
//

/**
 * 岛屿数量
 *
 * @author hsfxuebao
 * 2023-11-12 10:19:35 
 */
class P200_NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200_NumberOfIslands().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numIslands(char[][] grid) {

            if (grid == null) {
                return 0;
            }
            int res = 0;
            int row = grid.length;
            int col = grid[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i,j);
                        res++;
                    }
                }
            }
            return res;

        }

        private void dfs(char[][] grid, int i, int j) {

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';

            // 上下左右
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);




        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
