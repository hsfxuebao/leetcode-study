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
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3229, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author hsfxuebao
 * 2023-05-19 09:54:48 
 */
class P22_GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        backtrack(n, n, sb);
        return result;
    }

        /**
         *
         * @param left 左括号剩余的数量
         * @param right 右括号剩余的数量
         * @param sb
         */
        private void backtrack(int left, int right, StringBuilder sb) {

            // 非法
            if (left < 0 || right < 0) {
                return;
            }
            // 非法，左括号的数量必须大于等于有括号的数量
            // 剩余的左括号的数量 小于 有括号的数量
            if (left > right) {
                return;
            }
            if (left == 0 && right == 0) {
                result.add(sb.toString());
                return;
            }


            // 选择集
            sb.append("(");
            backtrack(left-1, right, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            backtrack(left, right-1, sb);
            sb.deleteCharAt(sb.length() - 1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
