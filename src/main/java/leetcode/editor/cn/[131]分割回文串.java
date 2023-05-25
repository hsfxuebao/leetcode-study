package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1514, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 *
 * @author hsfxuebao
 * 2023-05-25 19:10:43 
 */
class P131_PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new P131_PalindromePartitioning().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        List<List<String>> res = new ArrayList<>();
        LinkedList<String> track = new LinkedList<>();
    public List<List<String>> partition(String s) {

        backstack(s, 0);
        return res;
    }

        /**
         * 回溯算法
         */
        private void backstack(String s, int start) {

            // 终止条件
            if (start == s.length()) {
                res.add(new ArrayList<>(track));
                return;
            }

            // 选择集
            for (int i = start; i < s.length(); i++) {

                // 判断是否回文串
                if (isPalindrome(s, start, i)) {

                    // 选择
                    track.add(s.substring(start, i+1));
                    // 递归
                    backstack(s, i+1);
                    // 撤销选择
                    track.removeLast();
                }
            }
        }

        /**
         * 判断是否 回文串
         */
        private boolean isPalindrome(String s, int left, int right) {

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
