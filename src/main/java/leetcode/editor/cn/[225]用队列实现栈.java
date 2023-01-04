package leetcode.editor.cn;

//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否仅用一个队列来实现栈。 
// Related Topics 栈 设计 队列 
// 👍 640 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author hsfxuebao
 * 2023-01-04 16:56:03 
 */
class P225_ImplementStackUsingQueues{
    public static void main(String[] args) {
        MyStack solution = new P225_ImplementStackUsingQueues().new MyStack();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

        private Queue<Integer> q1;
        private Queue<Integer> q2;

        /**
         * 使用两个队列实现
         * 使用一个队列实现
         */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
//        q2.offer(x);
//        while (!q1.isEmpty()) {
//            q2.offer(q1.poll());
//        }
//        // 交换
//        Queue temp = q1;
//        q1 = q2;
//        q2 = temp;
        /**
         * 用一个队列实现
         */
        int size = q1.size();
        q1.offer(x);
        while (size > 0) {
            q1.offer(q1.poll());
            size--;
        }

    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
