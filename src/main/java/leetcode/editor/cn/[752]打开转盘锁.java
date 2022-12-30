package leetcode.editor.cn;

//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
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
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
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
// Related Topics 广度优先搜索 数组 哈希表 字符串 
// 👍 577 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.crypto.CipherSpi;


/**
 * 打开转盘锁
 *
 * @author hsfxuebao
 * 2022-12-30 11:00:54 
 */
class P752_OpenTheLock{
    public static void main(String[] args) {
        Solution solution = new P752_OpenTheLock().new Solution();
        String[] dead = {};
        solution.openLock(dead, "0001");
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * BFS
         * 从 起点 -> 终点遍历
         */
    public int openLock1(String[] deadends, String target) {

        // 死锁
        Set<String> deadSet = new HashSet<>();
        for (String dead : deadends) {
            deadSet.add(dead);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        // 记录 已经遍历过了
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                String str = queue.poll();
                if (deadSet.contains(str)) {
                    continue;
                }
                if (str.equals(target)) {
                    return step;
                }

                // 每一个字母可 向上  向下 波动
                for (int j = 0; j < target.length(); j++) {

                    // 向上
                    String upStr = up(str, j);
                    if (!visited.contains(upStr)) {
                        queue.offer(upStr);
                        visited.add(upStr);
                    }
                    // 向下
                    String downStr = down(str, j);
                    if (!visited.contains(downStr)) {
                        queue.offer(downStr);
                        visited.add(downStr);
                    }
                }

            }
            step++;
        }
        return -1;
    }

        /**
         * BFS
         * 从起点 ，终点同时开始搜索
         */
        public int openLock(String[] deadends, String target) {

            // 死锁
            Set<String> deadSet = new HashSet<>();
            for (String dead : deadends) {
                deadSet.add(dead);
            }

            Set<String> q1 = new HashSet<>();
            q1.add("0000");
            Set<String> q2 = new HashSet<>();
            q2.add(target);

            // 记录 已经遍历过了
            Set<String> visited = new HashSet<>();
            int step = 0;

            while (!q1.isEmpty() && !q2.isEmpty()) {

                // 那个set集合的数少，就遍历那个
                if (q2.size() < q1.size()) {
                    Set<String> temp = q1;
                    q1 = q2;
                    q2 = temp;
                }

                //
                Set<String> temp = new HashSet<>();
                for (String curStr : q1) {

                    if (deadSet.contains(curStr)) {
                        continue;
                    }
                    // 相交点
                    if (q2.contains(curStr)) {
                        return step;
                    }

                    visited.add(curStr);

                    for (int i = 0; i < target.length(); i++) {
                        // 向上
                        String upStr = up(curStr, i);
                        if (!visited.contains(upStr)) {
                            temp.add(upStr);
                        }
                        // 向下
                        String downStr = down(curStr, i);
                        if (!visited.contains(downStr)) {
                            temp.add(downStr);
                        }
                    }
                }
                step++;
                // 交换队列,只遍历q1
                q1 = q2;
                q2 = temp;
            }
            return -1;

        }
        // 向上 拨动
        private String up(String str, int j) {

            char[] chars = str.toCharArray();

            if (chars[j] == '0') {
                chars[j] = '9';
            } else {
                chars[j] -= 1;
            }
            return new String(chars);
        }
        // 向上 拨动
        private String down(String str, int j) {

            char[] chars = str.toCharArray();

            if (chars[j] == '9') {
                chars[j] = '0';
            } else {
                chars[j] += 1;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
