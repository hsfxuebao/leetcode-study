package leetcode.editor.cn;

//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用
//这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// dislikes 中每一组都 不同 
// 
//
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 图 
//
// 👍 356, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.LinkedList;
import java.util.List;


/**
 * 可能的二分法
 *
 * @author hsfxuebao
 * 2023-01-31 17:30:00 
 */
class P886_PossibleBipartition{
    public static void main(String[] args) {
        Solution solution = new P886_PossibleBipartition().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 是否符合二分图
        boolean ok = true;
        //
        boolean[] color;
        boolean[] visited;
        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 图节点编号从1开始
            color = new boolean[n+1];
            visited = new boolean[n+1];
            // 构建图
            List<Integer>[] graph = buildGraph(n, dislikes);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    traverse(graph, i);
                }
            }
            return ok;
        }

        /**
         * DFS
         */
        private void traverse(List<Integer>[] graph, int start) {

            if (!ok) {
                return;
            }

            visited[start] = true;
            for (int next : graph[start]) {

                if (!visited[next]) {
                    color[next] = !color[start];
                    traverse(graph, next);
                } else {
                    if (color[next] == color[start]) {
                        ok = false;
                        return;
                    }
                }

            }
        }

        /**
         * 构建  无向图
         */
        private List<Integer>[] buildGraph(int n, int[][] dislikes) {

            List<Integer>[] graph = new LinkedList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] dislike : dislikes) {

                int v = dislike[1];
                int w = dislike[0];
                // 「无向图」相当于「双向图」
                // v -> w
                graph[v].add(w);
                // w -> v
                graph[w].add(v);
            }
            return graph;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
