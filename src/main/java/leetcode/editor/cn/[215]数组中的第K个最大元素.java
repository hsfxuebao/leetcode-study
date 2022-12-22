package leetcode.editor.cn;


import java.util.PriorityQueue;
import java.util.Random;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 使用小根堆，优先队列实现
     * 时间复杂度：o(nlogk)
     * 空间复杂度：o(k)
     */
    public int findKthLargest1(int[] nums, int k) {

        if (nums.length <= 0) {
            return 0;
        }

        // 小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 使用快排
     * 时间复杂度：o(logn)
     * 空间复杂度 :
     */
    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        k = len - k;
        QuickSort quickSort = new QuickSort();
        // 随机排序
        quickSort.shuffle(nums);

        int left = 0, right = len - 1;
        while (left <= right) {

            int[] partition = quickSort.partition(nums, left, right);

            if (partition[0] <= k && partition[1] >= k) {
                return nums[partition[0]];

            } else if (partition[1] < k) {
                left = partition[1] + 1;
            } else if (partition[0] > k) {
                right = partition[0] - 1;
            }
        }
        return -1;
    }

}

class QuickSort {


    public void sort(int[] nums) {
        int len = nums.length;
        // 洗牌算法
        shuffle(nums);
        sort(nums, 0 ,len - 1);
    }

    public void sort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        int[] partition = partition(nums, left, right);
        sort(nums, left, partition[0] - 1);
        sort(nums, partition[1] + 1, right);

    }

    /**
     * 左边 小于 某个数  中间等于某个数  右边大于某个数
     */
    public int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        // 以最右边 right 为 某个数划分
        while (left < more) {

            if (nums[left] > nums[right]) {
                swap(nums, left, --more);
            } else if (nums[left] < nums[right]) {
                swap(nums, left++, ++less);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{ less + 1, more};
    }

    public void shuffle(int[] nums) {
        int len = nums.length;
        Random random = new Random();

        for (int i = 0; i < len; i++) {

            // 选取 [i, n-i) 直接的某个数
            int randomIndex = i + random.nextInt(len - i);
            swap(nums, i, randomIndex);
        }

    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        new QuickSort().sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println(new Solution().findKthLargest(nums, 2));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
