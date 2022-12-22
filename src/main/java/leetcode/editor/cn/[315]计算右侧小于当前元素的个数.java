package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution315 {

    private class Pair {

        // 当前数组中元素的值
        private int value;
        // 当前数组元素值 所在数组中的index
        private int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        public int getValue() {
            return value;
        }
        public int getIndex() {
            return index;
        }
    }


    // 归并排序所用的辅助数组
    private Pair[] temp;
    // 记录每个元素后面比自己小的元素个数
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {

        if (nums.length <= 0) {
            return null;
        }

        Pair[] pairNum = new Pair[nums.length];
        temp = new Pair[nums.length];
        count = new int[nums.length];
        // 记录元素原始的索引位置，以便在 count 数组中更新结果
        for (int i = 0; i < nums.length; i++) {
            pairNum[i] = new Pair(nums[i], i);
        }

        // 执行归并排序，本题结果被记录在 count 数组中
        sort(pairNum, 0, pairNum.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int cnt : count) {
            res.add(cnt);

        }
        return res;
    }

    // 归并排序
    private void sort(Pair[] pairNum, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // 左右两边
        sort(pairNum, left, mid);
        sort(pairNum, mid + 1, right);
        merge(pairNum, left, mid, right);

    }

    private void merge(Pair[] pairNum, int left, int mid, int right) {

        // 给临时变量赋值
        for (int i = left; i <= right; i++) {
            temp[i] = pairNum[i];
        }

        // 合并排序
        // i 表示左边开始的位置，j表示右边开始的位置
        int i = left, j = mid + 1;

        for (int m = left; m <= right; m++) {
            if (i == mid + 1) {
                pairNum[m] = temp[j++];
            } else if (j == right + 1) {
                pairNum[m] = temp[i++];
                // 更新 count 数组
                count[pairNum[m].getIndex()] += j - (mid + 1);
            } else if (temp[i].getValue() > temp[j].getValue()) {
                pairNum[m] = temp[j++];

            } else {
                pairNum[m] = temp[i++];
                // 更新 count 数组
                count[pairNum[m].getIndex()] += j - (mid + 1);
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
