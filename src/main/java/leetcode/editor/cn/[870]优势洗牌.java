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
// 1 <= nums1.length <= 105 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 贪心 数组 双指针 排序 
// 👍 353 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {



        // 优先队列，排序nums2数组  降序
        PriorityQueue<Number> pq = new PriorityQueue<Number>(
                (Number num1, Number num2) -> {
                    return num2.getValue() - num1.getValue();
                });
        // 对nums2排序
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new Number(i, nums2[i]));
        }

        // 对num1进行 升序
        Arrays.sort(nums1);
        // 记录 nums1的左右指针
        // // nums1[left] 是最小值，nums1[right] 是最大值
        int left = 0, right = nums1.length - 1;
        int res[] = new int[nums1.length];
        while (!pq.isEmpty()) {
            Number number = pq.poll();
            // value 是 nums2 中的最大值，index 是对应索引
            int value = number.getValue();
            int index = number.getIndex();

            if (value < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[index] = nums1[right--];
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[index] = nums1[left++];
            }
        }
        return res;
    }
}

class Number {
    private int index;
    private int value;

    public Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public int getIndex() {
        return index;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
