package leetcode.editor.cn;

//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
// 
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 二分查找 | 矩阵 | 堆（优先队列） 
//
// 👍 336, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.*;

/**
 * 最小体力消耗路径
 *
 * @author hsfxuebao
 * 2023-02-04 17:40:45 
 */
class P1631_PathWithMinimumEffort{
    public static void main(String[] args) {
        Solution solution = new P1631_PathWithMinimumEffort().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int minimumEffortPath(int[][] heights) {
            int row = heights.length;
            int col = heights[0].length;

            int[][] heightTo = new int[row][col];
            // 初始化
            for (int i = 0; i < row; i++) {
                Arrays.fill(heightTo[i], Integer.MAX_VALUE);
            }
            // base case
            heightTo[0][0] = 0;
            // 优先级队列，升序排序
            Queue<State> pq = new PriorityQueue<>((a,b) -> {
                return a.heightFromStart - b.heightFromStart;
            });
            pq.offer(new State(0, 0, 0));

            while (!pq.isEmpty()) {

                State curNode = pq.poll();
                int curX = curNode.x;
                int curY = curNode.y;
                int curHeightFromStart = curNode.heightFromStart;

                if (curX == row - 1 && curY == col - 1) {
                    return curHeightFromStart;
                }
                if (curHeightFromStart > heightTo[curX][curY]) {
                    continue;
                }

                //
                for (int[] adj : adj(heights, curX, curY)) {

                    int nextX = adj[0];
                    int nextY = adj[1];
                    int nextHeight = Math.max(heightTo[curX][curY],
                            Math.abs(heights[curX][curY]-heights[nextX][nextY]));
                    if (nextHeight < heightTo[nextX][nextY]) {
                        heightTo[nextX][nextY] = nextHeight;
                        pq.offer(new State(nextX, nextY, nextHeight));
                    }
                }

            }
            return -1;
        }


        class State {
            private int x;
            private int y;
            private int heightFromStart;

            public State(int x, int y, int heightFromStart) {
                this.x = x;
                this.y = y;
                this.heightFromStart = heightFromStart;
            }
        }


        // 上下左右 四个方向
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        // 返回坐标 (x, y) 的上下左右相邻坐标
        List<int[]> adj(int[][] matrix, int x, int y) {
            int row = matrix.length;
            int col = matrix[0].length;

            List<int[]> neighbors = new ArrayList<>();
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= row || nx < 0 || ny >= col || ny < 0) {
                    continue;
                }
                neighbors.add(new int[]{nx, ny});
            }
            return neighbors;
        }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}
