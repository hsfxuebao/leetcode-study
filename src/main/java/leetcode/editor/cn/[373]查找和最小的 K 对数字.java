package leetcode.editor.cn;

//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为升序排列 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics数组 | 堆（优先队列） 
//
// 👍 521, 👎 0 
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
 * 查找和最小的 K 对数字
 *
 * @author hsfxuebao
 * 2023-09-19 10:06:52 
 */
class P373_FindKPairsWithSmallestSums{
    public static void main(String[] args) {
        Solution solution = new P373_FindKPairsWithSmallestSums().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        Queue<NumberPair> queue = new PriorityQueue<>(new Comparator<NumberPair>() {
            @Override
            public int compare(NumberPair o1, NumberPair o2) {
                return (o1.getNum1() + o1.getNum2()) - (o2.getNum1() + o2.getNum2());
            }
        });

        // 将num1数组中的所有节点放到队列中
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new NumberPair(nums1[i], nums2[0], 0));
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            NumberPair pair = queue.poll();
            k--;
            // 加入到结果中
            List<Integer> res = new ArrayList<>();
            res.add(pair.getNum1());
            res.add(pair.getNum2());
            result.add(res);

            // 加入新的数据
            int num2Index = pair.getNum2Index();
            if (num2Index < nums2.length - 1) {
                queue.offer(new NumberPair(pair.getNum1(), nums2[num2Index+1], num2Index+1));
            }
        }
        return result;

    }


        public class NumberPair {

            int num1;
            int num2;
            int num2Index;

            public NumberPair(int num1, int num2, int num2Index) {
                this.num1 = num1;
                this.num2 = num2;
                this.num2Index = num2Index;
            }

            public int getNum1() {
                return num1;
            }

            public void setNum1(int num1) {
                this.num1 = num1;
            }

            public int getNum2() {
                return num2;
            }

            public void setNum2(int num2) {
                this.num2 = num2;
            }

            public int getNum2Index() {
                return num2Index;
            }

            public void setNum2Index(int num2Index) {
                this.num2Index = num2Index;
            }
        }

}

//leetcode submit region end(Prohibit modification and deletion)
 
}
