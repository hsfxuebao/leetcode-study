package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics数组 | 哈希表 | 分治 | 桶排序 | 计数 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 1692, 👎 0 
//
//
//
//

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 前 K 个高频元素
 *
 * @author hsfxuebao
 * 2023-09-20 17:23:47 
 */
class P347_TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new P347_TopKFrequentElements().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> val2FreMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer oldFre = val2FreMap.getOrDefault(nums[i], 0);
            val2FreMap.put(nums[i], oldFre+1);
        }
        // 大顶堆
        Queue<NumberFre> queue = new PriorityQueue<>(new Comparator<NumberFre>() {
            @Override
            public int compare(NumberFre o1, NumberFre o2) {
                return o1.getFre() - o2.getFre();
            }
        });

        for (Map.Entry<Integer, Integer> param : val2FreMap.entrySet()) {
            Integer val = param.getKey();
            Integer fre = param.getValue();
            queue.offer(new NumberFre(val, fre));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                result[i] = queue.poll().getNumber();
            }
        }
        return result;

    }

        public class NumberFre {
            int number;
            int fre;

            public NumberFre(int number, int fre) {
                this.number = number;
                this.fre = fre;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getFre() {
                return fre;
            }

            public void setFre(int fre) {
                this.fre = fre;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
