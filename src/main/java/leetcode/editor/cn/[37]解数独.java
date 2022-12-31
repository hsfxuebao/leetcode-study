package leetcode.editor.cn;

//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 
// 👍 1487 👎 0

/**
 * 解数独
 *
 * @author hsfxuebao
 * 2022-12-31 19:03:45 
 */
class P37_SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37_SudokuSolver().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 回溯算法
         * 路径，选择，结束条件
         * 从第一行 的第一列开始到 第一行最后一列
         * ，然后开始第二行
         */
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

        private boolean dfs(char[][] board, int i, int j) {
            // m 行数 n列数
            int m = 9, n = 9;
            // 当前行的每一列都遍历完了，开始下一行
            if (j == n) {
                // 穷举到最后一列的话就换到下一行重新开始。
                return dfs(board, i+1, 0);
            }

            // 递归到 最后一行的下一行 表示找到可行解了
            if (i == m) {
                return true;
            }

            // 当前位置 不是空的，继续递归
            if (board[i][j] != '.') {
                return dfs(board, i, j+1);
            }
            // 选择集
            for (char ch = '1'; ch <='9'; ch++) {

                // 一些非法条件
                if (!valid(board, i, j, ch)) {
                    continue;
                }
                board[i][j] = ch;
                if (dfs(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
            return false;
        }

        private boolean valid(char[][] board, int row, int col, char ch) {

            int m = 9, n = 9;

            for (int i = 0; i < m; i++) {
                // 当前数 所在列 不能重复数字
                if (board[i][col] == ch) {
                    return false;
                }
                // 当前数 所在行 不能重复
                if (board[row][i] == ch) {
                    return false;
                }
                // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
                if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == ch)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
