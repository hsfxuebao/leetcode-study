package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author hsfxuebao
 * Created on 2023-02-02
 *
 * http://e.betheme.net/article/show-54604.html?action=onClick
 */
class P1135_最低成本联通所有城市 {


    int minimumCost(int n, int[][] connections) {

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
