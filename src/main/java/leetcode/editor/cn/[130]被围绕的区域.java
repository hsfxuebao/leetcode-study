package leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 914, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 被围绕的区域
 *
 * @author hsfxuebao
 * 2023-02-02 09:36:23 
 */
class P130_SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new P130_SurroundedRegions().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // 给 dummy 留一个额外位置
        UnionFind unionFind = new UnionFind(m*n +1);
        int dummy = m*n;
        // 将首列和末列的 O  与dummy联通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                unionFind.union(dummy, i*n);
            }
            if (board[i][n - 1] == 'O') {
                unionFind.union(dummy, i*n+n-1);
            }
        }
        // 将首行 和末行 的O  与dummy联通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
               unionFind.union(dummy, j);
            }
            if (board[m - 1][j] == 'O') {
                unionFind.union(dummy, (m-1) *n + j);
            }
        }

        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {

                if (board[i][j] == 'O') {
                    // 将此 O 与上下左右的 O 连通
                    for (int k = 0; k < d.length; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            unionFind.union(i*n+j, x*n+y);
                        }
                    }
                }

            }
        }
        // 所有不和dummy联通的 O 都要被替换
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O'
                        && !unionFind.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }

        }

    }



        class UnionFind {

            // 联通分量的个数
            private int count;
            // 存储每个节点的父节点
            private int[] parent;

            // n 为图中节点的个数
            public UnionFind(int n) {
                this.count = n;
                parent = new int[n];
                // 初始化 父节点都是自己
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }
            // 将节点p 和 q 连通
            public void union(int p, int q) {

                int rootP = find(p);
                int rootQ = find(q);
                if (rootQ == rootP) {
                    return;
                }
                // 连接两个节点
                parent[rootQ] = rootP;
                // 连通分量 -1
                count--;
            }

            // 判断两个节点 是否连通
            public boolean connected(int p, int q) {
                int rootQ = find(q);
                int rootP = find(p);
                return rootQ == rootP;
            }
            /**
             * 查找某个节点的根节点
             * 1. 直接查找 空间复杂度o(n)
             * 2. 查找节点的根节点，并进行路径压缩 空间复杂度o(1)
             */
            private int find(int x) {

                if (parent[x] !=x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            // 返回连通分量的个数
            public int count() {
                return count;
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
