package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 3915, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author hsfxuebao
 * 2023-05-12 09:46:02 
 */
class P20_ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && getLeft(ch) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

        private char getLeft(char ch) {
            if (ch == ')') {
                return '(';
            }
            if (ch == '}') {
                return '{';
            }
            return '[';

        }


    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
