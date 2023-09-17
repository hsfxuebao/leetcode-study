package leetcode.editor.cn;

//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics贪心 | 数组 | 双指针 | 排序 
//
// 👍 371, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优势洗牌
 *
 * @author hsfxuebao
 * 2023-04-13 20:39:12 
 */
class P870_AdvantageShuffle{
    public static void main(String[] args) {
        Solution solution = new P870_AdvantageShuffle().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        // 对nums2进行降序排序
        Queue<Number> queue = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new Number(i, nums2[i]));
        }
        // nums1升序排序
        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;
        int[] result = new int[nums1.length];
        while (!queue.isEmpty()) {
            Number number = queue.poll();
            int index = number.getIndex();
            int maxVal = number.getValue();

            if (nums1[right] > maxVal) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }

        }
        return result;
    }

}

    class Number{

        public int index;  // 数组中的索引
        public int value; // 数组中索引对应的值

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
        public int getIndex() {
            return this.index;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)
 
}

