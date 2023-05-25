package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics数组 | 回溯 | 矩阵 
//
// 👍 1599, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 单词搜索
 *
 * @author hsfxuebao
 * 2023-05-25 19:51:14 
 */
class P79_WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79_WordSearch().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        boolean found = false;
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

        private void dfs(char[][] board, int row, int col, String word, int index) {

            // 终止条件
            if (index == word.length()) {
                found = true;
                return;
            }
            if (found) {
                return;
            }

            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                return;
            }
            // 判断
            if (word.charAt(index) != board[row][col]) {
                return;
            }

            // 选择
            board[row][col] = (char)(-board[row][col]);
            dfs(board, row+1, col, word, index+1);
            dfs(board, row-1, col, word, index+1);
            dfs(board, row, col-1, word, index+1);
            dfs(board, row, col+1, word, index+1);
            board[row][col] = (char)(-board[row][col]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
