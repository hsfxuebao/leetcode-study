package leetcode.editor.cn;
//给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
//
// 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一
//个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。 
//
// 
// 
//
// 
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["Solution","pickIndex"]
//[[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 
//输入：
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 104 
// 1 <= w[i] <= 105 
// pickIndex 将被调用不超过 104 次 
// 
// Related Topics 数学 二分查找 前缀和 随机化 
// 👍 276 👎 0


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution528 {

    private int[] preSum;

    public Solution528(int[] w) {

        int len = w.length;
        preSum = new int[len + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }

    }
    
    public int pickIndex() {

        // 随机 index 从1~sum，
        // todo 由于 二分查找，返回的是大于等于target的最小索引下表，
        //  所以在这里 加+1（target+1） 返回时的是 大于targer的最小索引下标
        int randomIndex = new Random().nextInt(preSum[preSum.length - 1]) + 1;

        // 二分查找，左边最接近randomIndex
        int leftIndex = selectLeft(preSum, randomIndex);
        // todo  这里要 - 1
        return leftIndex - 1;
    }


    /**
     * 如果 存在目标元素，返回当前目标元素的索引
     * 不存在  目标 元素，返回 比target大的最小索引下标
     */
    private int selectLeft(int[] preSum, int target) {

        int left = 0, right = preSum.length - 1;
        while (left <= right) {

            int mid = left + ((right - left) >> 1);
            if (preSum[mid] < target) {
                left++;
            } else if (preSum[mid] > target) {
                right--;
            } else if (preSum[mid] == target) {
                right = mid - 1;
            }
        }
        // left不会越界
        return left;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
