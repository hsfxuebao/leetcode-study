package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution327 {
    private int lower;
    private int upper;
    private int count = 0;
    private long[] temp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        this.lower = lower;
        this.upper = upper;
        temp = new long[len + 1];
        // 计算数组前缀和
        long[] preSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 对前缀和 数组 归并排序
        sort(preSum, 0, len);
        return count;
    }

    private void sort(long[] preSum, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        sort(preSum, left, mid);
        sort(preSum, mid + 1, right);
        merge(preSum, left, mid, right);

    }

    private void merge(long[] preSum, int left, int mid, int right) {
        // 赋值
        for (int i = left; i <= right; i++) {
            temp[i] = preSum[i];
        }

        // 计算count的值
        int start = mid + 1, end = mid + 1;
        for (int k = left; k <= mid; k++) {

            //
            while (start <= right && preSum[start] - preSum[k] < lower) {
                start++;
            }
            while (end <= right && preSum[end] - preSum[k] <= upper) {
                end++;
            }
            count += end - start;
        }

        // 使用双指针 对有序数组进行排序
        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {
            if (i == mid + 1) {
                preSum[m] = temp[j++];
            } else if (j == right + 1) {
                preSum[m] = temp[i++];
            } else if (temp[i] > temp[j]) {
                preSum[m] = temp[j++];
            } else {
                preSum[m] = temp[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
