package leetcode.editor.cn;

//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 737, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.*;

/**
 * 课程表 II
 *
 * @author hsfxuebao
 * 2023-01-30 14:49:16 
 */
class P210_CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new P210_CourseScheduleIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // 记录后续遍历的结果
        List<Integer> postOrder = new ArrayList<>();
        // 是否存在 环
        boolean hasCycle;
        // 记录 路径  和 防止走回头路
        boolean[] visited,onPath;
        public int[] findOrder1(int numCourses, int[][] prerequisites) {

            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];

            // 遍历图
            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }

            // 有环图 无法进行拓扑排序
            if (hasCycle) {
                return new int[]{};
            }

            // 逆序
            Collections.reverse(postOrder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postOrder.get(i);
            }
            return res;

        }

        /**
         * 遍历图  DFS
         */
        private void traverse(List<Integer>[] graph, int index) {

            // 发现环
            if (onPath[index]) {
                hasCycle = true;
            }

            if (visited[index] || hasCycle) {
                return;
            }
            // 前序 遍历位置
            onPath[index] = true;
            visited[index] = true;
            for (int t : graph[index]) {
                traverse(graph, t);
            }
            // 后续遍历位置
            postOrder.add(index);
            onPath[index] = false;

        }


        /**
         * BFS
         */
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            // 计算 入度
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                indegree[to]++;
            }

            // 根据入度初始化队列中的节点，和环检测算法相同
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 记录拓扑排序的结果
            int[] res = new int[numCourses];
            // 记录遍历节点的顺序（索引）
            int count = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                // 弹出节点的顺序即为拓扑排序结果
                res[count] = cur;
                count++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }

            }
            // 有环 拓扑排序不存在
            if (count != numCourses) {
                return new int[]{};
            }
            return res;

        }

        /**
         * 构建图
         */
        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

            // 图中共有 numCourses 个节点
            List<Integer>[] graph = new ArrayList[numCourses];
            // 初始化
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            // 构建邻接表
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                // 添加一条从 from 指向 to 的有向边
                // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
                graph[from].add(to);
            }
            return graph;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
