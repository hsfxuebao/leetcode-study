package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics并查集 | 数组 | 哈希表 
//
// 👍 1642, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @author hsfxuebao
 * 2023-05-12 20:56:19 
 */
class P128_LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;

        // 遍历数组，找到 连续数组的第一个开头的元素
        for (int num : nums) {
            // 如果包含 num-1 说明不是第一个元素
            if (set.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int curLen = 1;
            while (set.contains(curNum+1)) {
                curNum += 1;
                curLen += 1;
            }

            res = Math.max(curLen, res);
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
