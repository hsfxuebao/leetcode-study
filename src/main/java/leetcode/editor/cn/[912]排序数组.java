package leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {

    public int[] sortArray(int[] nums) {
        new Merge().sort(nums);
        return nums;
    }
}

class Merge {

    private int[] temp;

    public void sort(int[] nums) {
        if (nums.length <= 0) {
            return;
        }
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        // 左右两边
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        // 合并 左 右两边  有序数组
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        // 赋值
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 数组双指针技巧
        // i左边数据开始位置  j 右边数组开始位置
        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {
            if (i == mid + 1) {
                nums[m] = temp[j++];
            } else if (j == right + 1) {
                nums[m] = temp[i++];
            }else if (temp[i] > temp[j]) {
                nums[m] = temp[j++];
            } else {
                nums[m] = temp[i++];
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)
