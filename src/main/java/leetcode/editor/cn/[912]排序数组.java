package leetcode.editor.cn;

import java.lang.reflect.Parameter;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {

    public int[] sortArray(int[] nums) {
        // 归并排序
//        new Merge().sort(nums);
        // 快排
        new Quick().sort(nums);
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

class Quick {

    public void sort(int[] nums) {

        int len = nums.length;
        if (len <= 1) {
            return;
        }
        // 对 nums数组 进行洗牌
        shuffle(nums);
        sort(nums, 0 , len - 1);

    }

    private void sort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        final int[] partition = partition(nums, left, right);
        // p 位置的左右两边排序
        sort(nums, left, partition[0] - 1);
        sort(nums, partition[1] + 1, right);

    }

    /**
     * 左边的都比 某个数 小
     * 中间的都与 某个数 相等
     * 右边的都比 某个数 大
     *
     * 返回
     */
    public int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, --more, left);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[] { less + 1, more };
    }
    /**
     * 洗牌算法
     */
    private void shuffle(int[] nums) {
        Random random = new Random();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //  // 生成 [i, n - 1] 的随机数
            swap(nums, i, i + random.nextInt(len - i));
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}


//leetcode submit region end(Prohibit modification and deletion)
