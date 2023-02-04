package leetcode.editor.cn;

//给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 
//的一条无向边，且该边遍历成功的概率为 succProb[i] 。 
//
// 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。 
//
// 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, 
//end = 2
//输出：0.25000
//解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, 
//end = 2
//输出：0.30000
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//输出：0.00000
//解释：节点 0 和 节点 2 之间不存在路径
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// 每两个节点之间最多有一条边 
// 
//
// Related Topics图 | 数组 | 最短路 | 堆（优先队列） 
//
// 👍 115, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.*;

/**
 * 概率最大的路径
 *
 * @author hsfxuebao
 * 2023-02-04 17:11:54 
 */
class P1514_PathWithMaximumProbability{
    public static void main(String[] args) {
        Solution solution = new P1514_PathWithMaximumProbability().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {


            List<double[]>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            // 计算邻接表
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                double weight = succProb[i];
                // 无向图就是双向图；先把 int 统一转成 double，待会再转回来
                graph[u].add(new double[]{v, weight});
                graph[v].add(new double[]{u, weight});
            }

            return dijkstra(start, end, graph);
        }

        class State {
            // 图节点id
            private int id;
            // 从start到当前节点的概率
            private double probFromStart;

            public State(int id, double probFromStart) {
                this.id = id;
                this.probFromStart = probFromStart;
            }
        }

        private double dijkstra(int start, int end, List<double[]>[] graph) {

            int n = graph.length;
            // 记录从start节点到当前节点的概率
            double[] probTo = new double[n];
            // 初始化
            Arrays.fill(probTo, -1);
            // base case
            probTo[start] = 1;
            // 队列，概率从大到小 排序
            Queue<State> pq = new PriorityQueue<>((a,b) -> {
                return Double.compare(b.probFromStart, a.probFromStart);
            });
            pq.offer(new State(start, 1));

            while (!pq.isEmpty()) {
                State curState = pq.poll();
                int curId = curState.id;
                double curProb = curState.probFromStart;

                // 到达end节点
                if (end == curId) {
                    return curProb;
                }

                if (curProb < probTo[curId]) {
                    // 已经有一条概率更大的路径到达 curNode 节点了
                    continue;
                }

                // 将 curNode 的相邻节点装入队列
                for (double[] edge : graph[curId]) {
                    int nextId = (int) edge[0];
                    // 看看从 curNode 达到 nextNode 的概率是否会更大
                    double nextProb = probTo[curId] * edge[1];

                    if (nextProb > probTo[nextId]) {
                        // 更新 dp table
                        probTo[nextId] = nextProb;
                        pq.offer(new State(nextId, nextProb));
                    }

                }
            }
            return 0.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
