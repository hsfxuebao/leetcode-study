package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 3009 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author hsfxuebao
 * 2022-12-31 18:45:20 
 */
class P22_GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 记录 路径
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }

        /**
         *
         * @param left 左括号的数量
         * @param right 右括号的数量
         * @param track 当前字符串
         */
        private void backtrack(int left, int right, StringBuilder track) {

            // 不合法 直接返回
            if (left < 0 || right < 0) {
                return;
            }
            // 剩下的 左括号的数量  小于  有括号的数量  非法
            if (right < left) {
                return;
            }
            if (left == 0 && right == 0) {
                res.add(track.toString());
                return;
            }

            // 左括号
            track.append("(");
            backtrack(left-1, right, track);
            track.deleteCharAt(track.length() - 1);

            // 右括号
            track.append(")");
            backtrack(left, right-1, track);
            track.deleteCharAt(track.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
