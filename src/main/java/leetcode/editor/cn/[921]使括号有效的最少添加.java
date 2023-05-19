package leetcode.editor.cn;

//只有满足下面几点之一，括号字符串才是有效的： 
//
// 
// 它是一个空字符串，或者 
// 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者 
// 它可以被写作 (A)，其中 A 是有效字符串。 
// 
//
// 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号 
//
// 
// 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。 
// 
//
// 返回 为使结果字符串 s 有效而必须添加的最少括号数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "())"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s = "((("
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含 '(' 和 ')' 字符。 
// 
//
// Related Topics栈 | 贪心 | 字符串 
//
// 👍 240, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 使括号有效的最少添加
 *
 * @author hsfxuebao
 * 2023-05-17 09:41:16 
 */
class P921_MinimumAddToMakeParenthesesValid{
    public static void main(String[] args) {
        Solution solution = new P921_MinimumAddToMakeParenthesesValid().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {

        // 需要增加左括号的数量
        int res = 0;
        // 统计左括号的数量（遇到右括号就减1）
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            // 遇到左括号+1
            if (ch == '(') {
                count++;
            } else {
                // 遇到右括号 减1
                count--;
                // count =-1 表示右括号多，此时需要增加一个左括号
                if (count == -1) {
                    res++;
                    count = 0;
                }
            }
        }
        return res + count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
