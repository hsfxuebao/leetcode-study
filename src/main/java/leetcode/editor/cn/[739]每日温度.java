package leetcode.editor.cn;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics栈 | 数组 | 单调栈 
//
// 👍 1462, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Stack;

/**
 * 每日温度
 *
 * @author hsfxuebao
 * 2023-04-16 18:13:46 
 */
class P739_DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new P739_DailyTemperatures().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[] dailyTemperatures1(int[] temperatures) {

            int[] res = new int[temperatures.length];

            // 这里放索引
            Stack<Integer> stack = new Stack<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {

                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;

        }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        Stack<NumberIndex> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek().value <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek().index - i;
            stack.push(new NumberIndex(temperatures[i], i));
        }
        return res;

    }

        class NumberIndex {
            int value;
            int index;
            public NumberIndex(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
