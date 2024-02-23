package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics栈 | 数学 | 字符串 
//
// 👍 736, 👎 0 
//
//
//
//

import java.util.Stack;

/**
 * 基本计算器 II
 *
 * @author hsfxuebao
 * 2023-12-06 10:06:38 
 */
class P227_BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new P227_BasicCalculatorIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    stack.add(num);
                }
                if (sign == '-') {
                    stack.add(-num);
                }
                if (sign == '*') {
                    stack.add(num * stack.pop());
                }
                if (sign == '/') {
                    stack.add(stack.pop() / num);
                }

                num = 0;
                sign = ch;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
