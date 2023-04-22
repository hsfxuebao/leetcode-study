package leetcode.editor.cn;

//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// Related Topics广度优先搜索 | 数组 | 哈希表 | 字符串 
//
// 👍 606, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 *
 * @author hsfxuebao
 * 2023-04-21 20:11:43 
 */
class P752_OpenTheLock{
    public static void main(String[] args) {
        Solution solution = new P752_OpenTheLock().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * BFS 起点到终点
         */
    public int openLock1(String[] deadends, String target) {

        // 记录 死亡集合
        Set<String> deadSet = new HashSet<>();
        for (String dead : deadends) {
            deadSet.add(dead);
        }
        // 记录已经走过的
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int count = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String cur = queue.poll();
                // 判断是否到达终点
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return count;
                }

                // 选择集
                for (int j = 0; j < 4; j++) {
                    // 向上拨动一次
                    String upStr = up(cur, j);
                    if (!visitedSet.contains(upStr)) {
                        queue.offer(upStr);
                        visitedSet.add(upStr);
                    }
                    // 向下拨动一次
                    String downStr = down(cur, j);
                    if (!visitedSet.contains(downStr)) {
                        queue.offer(downStr);
                        visitedSet.add(downStr);
                    }
                }

            }
            // +1
            count++;
        }

        return -1;

    }


        /**
         * 双向BFS
         */
        public int openLock(String[] deadends, String target) {

            // 死锁
            Set<String> deadSet = new HashSet<>();
            for (String deadend : deadends) {
                deadSet.add(deadend);
            }
            // 记录已经走过的路，防止走回头路
            Set<String> visited = new HashSet<>();

            Set<String> q1 = new HashSet<>();
            Set<String> q2 = new HashSet<>();
            q1.add("0000");
            q2.add(target);
            int step = 0;

            while (!q1.isEmpty() && !q2.isEmpty()) {

                Set<String> temp = new HashSet<>();

                // 始终遍历q1
                for (String cur : q1) {

                    if (deadSet.contains(cur)) {
                        continue;
                    }
                    if (q2.contains(cur)) {
                        return step;
                    }

                    visited.add(cur);

                    for (int i = 0; i < 4; i++) {
                        // 向上
                        String upStr = up(cur, i);
                        if (!visited.contains(upStr)) {
                            temp.add(upStr);
                        }

                        // 向下
                        String downStr = down(cur, i);
                        if (!visited.contains(downStr)) {
                            temp.add(downStr);
                        }
                    }
                }
                step++;
                // 交换队列
                q1 = q2;
                q2 = temp;

            }
            return -1;

        }

        /**
         * 将 s[j] 向上拨动一次
         */
    private String up(String str, int j) {
        char[] chars = str.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

        /**
         * 将 s[j] 向下拨动一次
         */
        private String down(String str, int j) {
            char[] chars = str.toCharArray();
            if (chars[j] == '0') {
                chars[j] = '9';
            } else {
                chars[j] -= 1;
            }
            return new String(chars);
        }



}
//leetcode submit region end(Prohibit modification and deletion)
 
}
