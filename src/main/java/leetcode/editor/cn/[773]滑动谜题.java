package leetcode.editor.cn;

//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（
//上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 示例 2: 
//
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 示例 3: 
//
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//
// 提示： 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// board[i][j] 中每个值都 不同 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 291 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * 滑动谜题
 *
 * @author hsfxuebao
 * 2022-12-30 20:52:07 
 */
class P773_SlidingPuzzle{
    public static void main(String[] args) {
        Solution solution = new P773_SlidingPuzzle().new Solution();
        int[][] board = {{1,2,3}, {4,0,5}};
        solution.slidingPuzzle(board);
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * BFS
         *
         */
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String startStr = sb.toString();
        String endStr = "123450";

        Queue<String> queue = new LinkedList<>();
        queue.offer(startStr);

        // 记录使用过的数据
        Set<String> visited = new HashSet<>();
        visited.add(startStr);
        int step = 0;

        // 记录 0 位置 相邻的索引数（上下左右）
        int[][] neighbor = {
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}
        };

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                String curStr = queue.poll();
                if (endStr.equals(curStr)) {
                    return step;
                }

                // 查找那个位置是数字0
                int zeroIndex = 0;
                char[] chars = curStr.toCharArray();
                for (; zeroIndex < endStr.length(); zeroIndex++) {
                    if (chars[zeroIndex] == '0') {
                        break;
                    }
                }
                // 交换数字0 的 上下左右位置
                int[] temp = neighbor[zeroIndex];
                for (int index : temp) {
                    // 交换位置 todo curStr必须是原来数组
                    String swapStr = swap(curStr.toCharArray(), zeroIndex, index);
                    if (!visited.contains(swapStr)) {
                        queue.offer(swapStr);
                        visited.add(swapStr);
                    }
                }
            }

            step++;
        }
        return -1;
    }

        private String swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            return new String(chars);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
