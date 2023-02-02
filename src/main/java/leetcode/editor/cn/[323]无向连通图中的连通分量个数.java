package leetcode.editor.cn;

/**
 * @author hsfxuebao
 * Created on 2023-02-01
 *
 * https://blog.csdn.net/u011240016/article/details/100521176
 */
class P323_无向连通图中的连通分量个数 {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        // 将每个节点进行连通
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        // 返回连通分量的个数
        return uf.count();
    }

    class UnionFind {

        // 联通分量的个数
        private int count;
        // 存储每个节点的父节点
        private int[] parent;
        // 每个节点下的节点数量
        private int[] size;

        // n 为图中节点的个数
        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
//        size = new int[n];
            // 初始化 父节点都是自己
            for (int i = 0; i < n; i++) {
                parent[i] = i;
//            size[i] = 1;
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
            parent[rootP] = rootQ;
            // 连通分量 -1
            count--;
            // 平衡优化，维护每个根节点对应的节点数量，小树接到大树下面，较平衡
//        if (size[rootQ] > size[rootP]) {
//            parent[rootP] = rootQ;
//            size[rootQ] += size[rootP];
//        } else {
//            parent[rootQ] = rootP;
//            size[rootP] += size[rootQ];
//        }
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

            // 方式1
//        while (parent[p] != p) {
//            p = parent[p];
//        }
//        return p;
            // 方式2
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
