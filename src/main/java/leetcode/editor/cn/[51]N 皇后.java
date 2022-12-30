package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {

    private List<List<String>> res = new ArrayList<>();

    /**
     * 回溯算法
     *
     */
    /* 输入棋盘边长 n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        // 初始化 全部都是.
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0);
        return res;
    }
    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backtrack(char[][] board, int row) {
        // 结束条件
        if (row == board.length) {
            // 转换
            List<String> result = transToStr(board);
            res.add(result);
            return;
        }

        // 选择集
        for (int col = 0; col < board.length; col++) {
            // 校验是否非法
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 下一行 递归
            backtrack(board, row + 1);
            // 删除选择
            board[row][col] = '.';
        }

    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    private boolean isValid(char[][] board, int row, int col) {
        // 检验列有数据  不合法
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 右上方
        int i, j;
        for (i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 左上方
        for (i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    private List<String> transToStr(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
