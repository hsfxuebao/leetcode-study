package leetcode.editor.cn;

//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics广度优先搜索 | 数组 | 矩阵 
//
// 👍 695, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * @author hsfxuebao
 * 2023-05-24 18:50:10 
 */
class P994_RottingOranges{
    public static void main(String[] args) {
        Solution solution = new P994_RottingOranges().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * bfs 广度优先遍历
         */
    public int orangesRotting(int[][] grid) {

        // 分别对应 上 下 左 右
        int[] rowDp = new int[]{-1,1,0,0};
        int[] colDp = new int[]{0,0,-1,1};

        int m = grid.length;
        int n = grid[0].length;

        // 将二维位置  转换成一维，然后在使用的时候在拆成二维的
        // index = row * 列数 + col
        // row = index / 列数；  col = index % 列数
        Queue<Integer> queue = new LinkedList<>();
        // 多维度  记录前进一步
        Map<Integer, Integer> num2DeptMap = new HashMap<>();

        int depth = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 腐烂的橘子 加入到初始步骤
                if (grid[i][j] == 2) {
                    int index = i * n + j;
                    queue.add(index);
                    num2DeptMap.put(index, 0);
                }
            }
        }

        // bfs遍历
        while (!queue.isEmpty()) {

            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {

                Integer curIndex = queue.poll();
                // 拆成 二维
                int curRow = curIndex / n;
                int curCol = curIndex % n;

                // 选择集
                // 上下左右
                for (int j = 0; j < rowDp.length; j++) {
                    int nextRow = curRow + rowDp[j];
                    int nextCol = curCol + colDp[j];
                    int nextIndex = nextRow * n + nextCol;
                    // 符合条件，放到下一个
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                            && grid[nextRow][nextCol] == 1) {

                        grid[nextRow][nextCol] = 2;
                        queue.add(nextIndex);
                        num2DeptMap.put(nextIndex, num2DeptMap.get(curIndex)+1);
                        depth = num2DeptMap.get(nextIndex);
                    }
                }
            }
            // todo 为啥不在这里累计步骤，[0,-2] 按照下面 depth=1, 但是实际上应该等于0
            // dept++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return depth;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
 
}
