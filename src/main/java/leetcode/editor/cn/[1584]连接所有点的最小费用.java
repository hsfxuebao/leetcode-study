package leetcode.editor.cn;

//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。 
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// 所有点 (xi, yi) 两两不同。 
// 
//
// Related Topics并查集 | 图 | 数组 | 最小生成树 
//
// 👍 260, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.*;

/**
 * 连接所有点的最小费用
 *
 * @author hsfxuebao
 * 2023-02-02 19:40:50 
 */
class P1584_MinCostToConnectAllPoints{
    public static void main(String[] args) {
        Solution solution = new P1584_MinCostToConnectAllPoints().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xj - xi) + Math.abs(yj - yi);
                edges.add(new int[]{i, j, weight});
            }
        }

        // 排序，按照权重从小到大 排序
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        // 执行 Kruskal 算法
        int mst = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }
            uf.union(u, v);
            mst += weight;
        }

        return mst;


    }

        class UnionFind {

            // 联通分量的数量
            private int count;
            private int[] parent;
            public UnionFind(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int rootQ = find(q);
                int rootP = find(p);
                if (rootQ == rootP) {
                    return;
                }
                parent[rootP] = rootQ;
                count--;
            }

            private int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            private boolean connected(int p, int q) {
                int rootQ = find(q);
                int rootP = find(p);
                return rootQ == rootP;
            }

            public int count() {
                return count;
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
