package leetcode.editor.cn;

//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希 
//
// 👍 485, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 *
 * @author hsfxuebao
 * 2023-05-20 16:32:53 
 */
class P187_RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new P187_RepeatedDnaSequences().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 使用 进制数 计算需要匹配的字符串的数值
         */
    public List<String> findRepeatedDnaSequences(String s) {

        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'A': nums[i] = 0;
                break;
                case 'C': nums[i] = 1;
                break;
                case 'G': nums[i] = 2;
                    break;
                case 'T': nums[i] = 3;
                    break;
            }
        }

        // 进制
        int R = 4;
        // 匹配字符串的长度
        int L = 10;
        long RL = (long) Math.pow(R, L-1);
        long windowHash = 0;


        // 存放重复的字符串 Set结构可以去重
        Set<String> res = new HashSet<>();
        // 存放匹配字符串的值
        Set<Long> set = new HashSet<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            // 右移窗口
            windowHash = R * windowHash + nums[right];
            right++;

            while (right - left == L) {

                // 判断是否重复
                if (set.contains(windowHash)) {
                    res.add(s.substring(left, left + L));
                } else {
                    set.add(windowHash);
                }
                // 左移窗口
                windowHash = windowHash - RL * nums[left];
                left++;
            }
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
