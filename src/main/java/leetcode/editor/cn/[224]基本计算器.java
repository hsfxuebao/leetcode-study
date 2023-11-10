package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics栈 | 递归 | 数学 | 字符串 
//
// 👍 914, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 基本计算器
 *
 * @author hsfxuebao
 * 2023-06-16 21:40:14 
 */
class P224_BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new P224_BasicCalculator().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        return helper(queue);
    }


        // 计算
        private int helper(Queue<Character> queue) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';

            while (!queue.isEmpty()) {
                Character ch = queue.poll();
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                }
                if (ch == '(') {
                    num = helper(queue);
                }

                if ((!Character.isDigit(ch) && ch != ' ')
                        || queue.isEmpty()) {

                    if (sign == '+') {
                        stack.push(num);
                    }
                    if (sign == '-') {
                        stack.push(-num);
                    }
                    if (sign == '*') {
                        stack.push(stack.pop() * num);
                    }
                    if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    num = 0;
                    sign = ch;
                }
                if (ch == ')') {
                    break;
                }
            }
            // 求和计算
            int  res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
