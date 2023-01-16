package leetcode.editor.cn;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//

// 👍 1488, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 *
 * @author hsfxuebao
 * 2023-01-16 19:30:17 
 */
class P207_CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new P207_CourseSchedule().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // 记录遍历过的节点，防止走回头路
        private boolean[] visited;
        // 记录一次递归堆栈中的节点
        private boolean[] onPath;
        // 记录图中是否有环
        private boolean hasCycle;


        /**
         * BFS
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 构建图
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // 入度
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                // 节点 to 的入度加一
                indegree[to]++;
            }
            // 根据入度 初始化队列中的节点
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                // 节点 i 没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 记录遍历的节点数量
            int count = 0;
            // 开始执行 BFS 循环
            while (!queue.isEmpty()) {

                // 弹出节点 cur，并将它指向的节点的入度减一
                Integer cur = queue.poll();
                count++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }

            }
            // 如果所有节点都被遍历过，说明不成环
            return count == numCourses;
        }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        /**
         * dfs
         */
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        // 构造 图结构
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            dfs(i, graph);
        }

        return !hasCycle;
    }

        /**
         * 深度优先遍历
         */
        private void dfs( int value, List<Integer>[] graph) {

            // 出现重复节点
            if (onPath[value]) {
                hasCycle = true;
                return;
            }

            // 已经访问过的节点
            if (visited[value] || hasCycle) {
                return;
            }

            // 前序遍历节点
            // 将节点 s 标记为已遍历
            visited[value] = true;
            // 开始遍历节点 s
            onPath[value] = true;
            for (int s : graph[value]) {
                dfs(s, graph);
            }
            // 节点 s 遍历完成
            onPath[value] = false;
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
