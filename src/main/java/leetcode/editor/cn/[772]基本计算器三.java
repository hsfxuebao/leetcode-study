package leetcode.editor.cn;

/*
实现一个基本的计算器来计算一个简单的表达式字符串。

表达式字符串可以包含左括号 (和右括号 )、加号+或减号-、非负 整数和空格。

表达式字符串只包含非负整数、+, -, *, /操作符、左括号 (，右括号 )和空格。

您可以假设给定的表达式总是有效的。所有中间结果将在“[-2147483648,2147483647]”范围内。

不要使用eval内置的库函数。
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2023-11-10
 */
class P772_BasicCalculatorIi {

    public static void main(String[] args) {

    }
}

class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        return helper(queue);

    }

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
            if ((Character.isDigit(ch) && ch != ' ')
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
                // 更新
                num = 0;
                sign = ch;
            }
            if (ch == ')') {
                break;
            }

        }
        // 求和
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;


    }
}
