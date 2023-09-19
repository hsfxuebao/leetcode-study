package leetcode.editor.cn;

//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 请注意，它是 排序后 的第 k 小元素，而不是第 
//k 个 不同 的元素。 
//
// 你必须找到一个内存复杂度优于 O(n²) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n² 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题? 
// 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。 
// 
//
// Related Topics数组 | 二分查找 | 矩阵 | 排序 | 堆（优先队列） 
//
// 👍 995, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 有序矩阵中第 K 小的元素
 *
 * @author hsfxuebao
 * 2023-09-19 10:27:40 
 */
class P378_KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new P378_KthSmallestElementInASortedMatrix().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        Queue<NumberPair> queue = new PriorityQueue<>(new Comparator<NumberPair>() {
            @Override
            public int compare(NumberPair o1, NumberPair o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });

        // 将每行的第一个元素放进去
        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new NumberPair(matrix[i][0], i, 0));
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            NumberPair pair = queue.poll();
            result.add(pair.getNumber());
            // 更新数据
            int row = pair.getRow();
            int col = pair.getCol() + 1;

            if (col < matrix[0].length) {
                queue.offer(new NumberPair(matrix[row][col], row, col));
            }
        }
        return k > result.size() ? -1 : result.get(k-1);
    }

        public class NumberPair {
            int number;
            int row;
            int col;



            public int getNumber() {
                return number;
            }

            public NumberPair(int number, int row, int col) {
                this.number = number;
                this.row = row;
                this.col = col;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getRow() {
                return row;
            }

            public void setRow(int row) {
                this.row = row;
            }

            public int getCol() {
                return col;
            }

            public void setCol(int col) {
                this.col = col;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
