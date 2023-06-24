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
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }
        return helper(queue);
    }

        private int helper(Queue<Character> queue) {


            Stack<Integer> numStack = new Stack<>();
            // 默认第一个数是 加号
            char sign = '+';
            int number = 0;
            while (!queue.isEmpty()) {

                Character ch = queue.poll();
                if (Character.isDigit(ch)) {
                    number = 10 * number + (ch - '0');
                }
                // 遇到左括号 开始进行递归计算
                if (ch == '(') {
                    number =  helper(queue);
                }
                if ((!Character.isDigit(ch) && ch != ' ') || queue.isEmpty()) {

                    switch (sign) {
                        case '+':
                            numStack.push(number);
                            break;
                        case '-':
                            numStack.push(-number);
                            break;
                        case '*' :
                            numStack.push(numStack.pop()*number);
                            break;
                        case '/' :
                            numStack.push(numStack.pop() / number);
                            break;
                        default:
                            break;
                    }
                    // 更新当前的符号
                    sign = ch;
                    number = 0;

                }
                // 遇到右括号 返回
                if (ch == ')') {
                    break;
                }

            }
            int sum = 0;
            while (!numStack.isEmpty()) {
                sum += numStack.pop();
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
