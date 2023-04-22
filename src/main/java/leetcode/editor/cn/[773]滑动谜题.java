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
//
// Related Topics广度优先搜索 | 数组 | 矩阵 
//
// 👍 301, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 滑动谜题
 *
 * @author hsfxuebao
 * 2023-04-21 20:54:09 
 */
class P773_SlidingPuzzle{
    public static void main(String[] args) {
        Solution solution = new P773_SlidingPuzzle().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {

        // 可移动的位置
        int[][] nextIndex = new int[][]{
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}
            };

        StringBuilder startBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startBuilder.append(board[i][j]);
            }
        }

        // 记录已走过的路 不走回头路
        Set<String> visited = new HashSet<>();
        visited.add(startBuilder.toString());

        // 队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(startBuilder.toString());
        int step = 0;
        String target = "123450";

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String cur = queue.poll();
                // 终止条件
                if (target.equals(cur)) {
                    return step;
                }
                // 找到 0 对应的位置
                int zeroIndex = getZeroIndex(cur);
                for (int index : nextIndex[zeroIndex]) {
                    String nextStr = swapIndex(cur.toCharArray(), zeroIndex, index);
                    if (!visited.contains(nextStr)) {
                        queue.offer(nextStr);
                        visited.add(nextStr);
                    }
                }

            }
            step++;
        }
        return -1;
    }

        private String swapIndex(char[] nums, int i, int j) {
                char temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                return new String(nums);
        }

        private int getZeroIndex(String cur) {
            char[] chars = cur.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ('0' == chars[i]) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
