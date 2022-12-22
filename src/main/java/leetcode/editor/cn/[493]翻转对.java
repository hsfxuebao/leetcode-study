package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution493 {
    // 记录重要反转对的数量
    private int count = 0;
    private int[] temp;

    public int reversePairs(int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return count;

    }

    /**
     * 归并排序
     */
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);


    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 赋值
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 计算重要反转对的数量
        // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]
        // 为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间
        int end = mid + 1;
        for (int i = left; i <= mid; i++) {

            while (end <= right && (long) nums[i] > 2 * (long) nums[end]) {
                end++;
            }
            count += end - (mid + 1);
        }

        // 数组双指针技巧，合并两个有序数组
        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {

            if (i == mid + 1) {
                nums[m] = temp[j++];
            } else if (j == right + 1) {
                nums[m] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[m] = temp[j++];
            } else {
                nums[m] = temp[i++];
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
