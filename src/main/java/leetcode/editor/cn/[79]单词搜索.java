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
// 👍 1730, 👎 0 
//
//
//
//

/**
 * 单词搜索
 *
 * @author hsfxuebao
 * 2023-12-21 09:33:22 
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

        private void dfs(char[][] board, int i, int j, String word, int p) {

            if (p == word.length()) {
                found = true;
                return;
            }
            if (found) {
                return;
            }
            // 非法
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return;
            }
            if (word.charAt(p) != board[i][j]) {
                return;
            }

            // 记录已经使用过了
            board[i][j] = (char)-board[i][j];
            // 上下左右查找
            dfs(board, i+1, j, word, p+1);
            dfs(board, i-1, j, word, p+1);
            dfs(board, i, j-1, word, p+1);
            dfs(board, i, j+1, word, p+1);
            // 撤销选择
            board[i][j] = (char)-board[i][j];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
