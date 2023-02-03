package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hsfxuebao
 * Created on 2023-02-02
 *
 * http://e.betheme.net/article/show-54604.html?action=onClick
 */
class P1135_最低成本联通所有城市 {


    /**
     * Prim最小生成树算法
     */
    int minimumCost(int n, int[][] connections) {
        // 转化成无向图邻接表的形式
        List<int[]>[] graph = buildGraph(n, connections);
        // 执行 Prim 算法
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) {
            // 最小生成树无法覆盖所有节点
            return -1;
        }
        return prim.weightSum();

    }

    // 构建 图
    private List<int[]>[] buildGraph(int n, int[][] connections) {
        // 图中共有n个节点
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            // 题目给的节点编号是从 1 开始的，
            // 但我们实现的 Prim 算法需要从 0 开始编号
            int u = connection[0] -1;
            int v = connection[1] - 1;
            int weight = connection[2];
            // 「无向图」其实就是「双向图」
            // 一条边表示为 int[]{from, to, weight}
            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }
        return graph;
    }

    class Prim {
        // 核心数据结构，存储「横切边」的优先级队列
        private PriorityQueue<int[]> pq;
        // 类似visited数组，记录那个节点已成为最小生成树节点
        private boolean[] inMst;
        // 记录最小生成数的权重之和
        int weightSum = 0;
        // graph 是用邻接表表示的一幅图，
        // graph[s] 记录节点 s 所有相邻的边，
        // 三元组 int[]{from, to, weight} 表示一条边
        private List<int[]>[] graph;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            // 按照边的权重从小到大排序
            this.pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
            int n = graph.length;
            inMst = new boolean[n];

            // 随便从一个节点开始切分，不防从节点0开始切分
            inMst[0] = true;
            cut(0);

            while (!pq.isEmpty()) {

                int[] edge = pq.poll();
                int to = edge[1];
                int weight = edge[2];
                if (inMst[to]) {
                    // 节点 to 已经在最小生成树中，跳过
                    // 否则这条边会产生环
                    continue;
                }
                // 将边 edge 加入最小生成树
                weightSum += weight;
                inMst[to] = true;
                // 节点 to 加入后，进行新一轮切分，会产生更多横切边
                cut(to);
            }

        }

        // 将 s 的横向边  加入优先队列
        private void cut(int s) {

            // 遍历s 的邻边
            for (int[] edge : graph[s]) {
                int to = edge[1];
                if (inMst[to]) {
                    // 相邻接点 to 已经在最小生成树中，跳过
                    // 否则这条边会产生环
                    continue;
                }
                // 加入横切边队列
                pq.offer(edge);
            }
        }
        // 最小生成树 权重之和
        public int weightSum() {
            return weightSum;
        }
        // 判断 最小生成树是否包含 图中的所有节点
        public boolean allConnected() {
            for (int i = 0; i < inMst.length; i++) {

                if (!inMst[i]) {
                    return false;
                }
            }
            return true;
        }

    }




    /**
     * KRUSKAL 最小生成树算法
     */
    int minimumCost1(int n, int[][] connections) {

        UnionFind uf = new UnionFind(n+1);

        // 按权重大小 升序 排序
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int mst = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int weight = connection[2];
            if (uf.connected(u, v)) {
                continue;
            }
            uf.union(u, v);
            mst += weight;
        }
        return uf.count == 2 ? mst : -1;
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
