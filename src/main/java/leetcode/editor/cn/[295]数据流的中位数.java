package leetcode.editor.cn;

//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics设计 | 双指针 | 数据流 | 排序 | 堆（优先队列） 
//
// 👍 875, 👎 0 
//
//
//
//

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流的中位数
 *
 * @author hsfxuebao
 * 2023-09-20 17:47:15 
 */
class P295_FindMedianFromDataStream{
    public static void main(String[] args) {
//        Solution solution = new P295_FindMedianFromDataStream().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {


        // 小顶堆
        Queue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        // 大顶堆
        Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (minQueue.size() >= maxQueue.size()) {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        } else {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        }

//        if (maxQueue.isEmpty()) {
//            maxQueue.offer(num);
//            return;
//        }
//
//        int maxVal = maxQueue.peek();
//        if (maxVal > num) {
//            maxQueue.offer(num);
//        } else {
//            minQueue.offer(num);
//        }
//
//        // 平衡两个队列的大小
//        if (maxQueue.size()-minQueue.size() >= 2) {
//            minQueue.offer(maxQueue.poll());
//        } else if (minQueue.size()-maxQueue.size() >= 2) {
//            maxQueue.offer(minQueue.poll());
//        }
    }
    
    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        }
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        }

        if (minQueue.size() > 0 && maxQueue.size() > 0
            && minQueue.size() == maxQueue.size()) {
            return (double) (minQueue.peek() + maxQueue.peek())/2.0;
        }
        return 0.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}
