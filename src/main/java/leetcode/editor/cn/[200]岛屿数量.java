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
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 2014 👎 0

/**
 * 岛屿数量
 *
 * @author hsfxuebao
 * 2022-12-30 21:40:22 
 */
class P200_NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200_NumberOfIslands().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {


        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                }
            }
        }
        return res;

    }
        // 从 (i, j) 开始，将与之相邻的陆地都变成海水
        private void dfs(char[][] grid, int i, int j) {
            // 超出索引边界
            if (i >= grid.length || i < 0
                    || j >= grid[0].length || j < 0) {
                return;
            }
            // 遇到海水返回
            if (grid[i][j] == '0') {
                return;
            }
            // 将 (i, j) 变成海水
            grid[i][j] = '0';
            // 淹没上下左右的陆地
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
