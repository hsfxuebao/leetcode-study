package leetcode.editor.cn;

/**
 * @author hsfxuebao
 * Created on 2023-02-02
 */
class P261_以图判树 {


    // 判断输入的若干条边是否能构造出一棵树结构
    public boolean validTree(int n, int[][] edges) {
        // 构建 0 - n-1 共有n个节点
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            // 遍历所有边，将组成边的两个节点进行链接
            if (uf.connected(u, v)) {
                return false;
            }
            // 这两条边不会产生环，是树的一部分
            uf.union(u, v);
        }
        return uf.count == 1;
    }



    class UnionFind {

        // 连通分量的个数
        private int count;
        //
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
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

        public boolean connected(int p, int q) {
            int rootQ = find(q);
            int rootP = find(p);
            return rootQ == rootP;
        }

        public int count() {
            return count;
        }

    }


}

