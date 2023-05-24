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
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
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
// Related Topics数组 | 哈希表 | 回溯 | 矩阵 
//
// 👍 1639, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 解数独
 *
 * @author hsfxuebao
 * 2023-05-24 09:51:06 
 */
class P37_SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37_SudokuSolver().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        backtrace(board, 0, 0);
    }

        private boolean backtrace(char[][] board, int row, int col) {

            if (col == board[0].length) {
                // 下一行
                return backtrace(board, row+1, 0);
            }

            if (row == board[0].length) {
                // 找到一个可行解
                return true;
            }
            // 当前位置不为空
            if (board[row][col] != '.') {
                return backtrace(board, row, col+1);
            }

            // 选择集
            for (char ch = '1'; ch <= '9'; ch++) {

                // 非法的字符，行 列 块出现重复的数字
                if (!isValid(board, row, col, ch)) {
                    continue;
                }

                // 选择
                board[row][col] = ch;
                if (backtrace(board, row, col + 1)) {
                    return true;
                }
                // 撤销选择
                board[row][col] = '.';
            }
            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char ch) {
            for (int i = 0; i < 9; i++) {
                // 每行不能出现同一字符
                if (board[row][i] == ch) {
                    return false;
                }
                // 每列不能出现同一字符
                if (board[i][col] == ch) {
                    return false;
                }
                // 3*3 方格内不能出现同一字符
                if (board[(row/3)*3 + i /3][(col/3)*3 + i%3] == ch) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
