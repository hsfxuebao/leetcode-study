package leetcode.editor.cn;

//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 875 👎 0

import java.util.Arrays;
import java.util.HashMap;

/**
 * 划分为k个相等的子集
 *
 * @author hsfxuebao
 * 2022-12-31 16:53:58 
 */
class P698_PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new P698_PartitionToKEqualSumSubsets().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 以数字视角，将数字 放入某一个桶中
         * 时间复杂度 o(k^n)
         */
    public boolean canPartitionKSubsets1(int[] nums, int k) {

        if (k > nums.length) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;
        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];

        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }
        // 递归穷举 nums 中的每个数字
        private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
            // 结束条件
            if (index == nums.length) {
                // 判断每一个桶中的数字是否等于target
                for (int num : bucket) {
                    if (num != target) {
                        return false;
                    }
                }
                // nums 成功平分成 k 个子集
                return true;
            }

            // 穷举 nums[index] 可能装入的桶
            for (int i = 0; i < bucket.length; i++) {
                // 剪枝，桶装装满了
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                // 做选择
                bucket[i] += nums[index];
                // 递归穷举下一个数字的选择
                if (backtrack(nums, index + 1, bucket, target)) {
                    return true;
                }
                // 撤销选择
                bucket[i] -= nums[index];
            }
            return false;
        }

        /**
         * 以桶为视角，那么每个数字 可选择 放入 或 不放入 这个桶
         * 时间复杂度 o(k*2^n)
         * 存在问题，就是会重复 计算之前的结果，可以使用备忘录记录结果
         */
        public boolean canPartitionKSubsets2(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;

            boolean[] used = new boolean[nums.length];
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack(k, 0, nums, 0, used, target);
        }

        private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
            // 结束条件
            if (k == 0) {
                return true;
            }
            // 当前桶装满了，递归一下个桶
            if (bucket == target) {
                return backtrack(k-1, 0, nums, 0, used, target);
            }

            // 选择集
            for (int i = start; i < nums.length; i++) {
                // 已经使用过了
                if (used[i]) {
                    continue;
                }

                if (bucket + nums[i] > target) {
                    continue;
                }

                // 做选择
                bucket += nums[i];
                used[i] = true;
                // 递归
                if (backtrack(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                bucket -= nums[i];
                used[i] = false;

            }
            return false;
        }

        /**
         * 以桶为视角，那么每个数字 可选择 放入 或 不放入 这个桶
         * 时间复杂度 o(k*2^n)
         * 使用备忘录记录结果
         * 备忘录key: 使用数组转成字符串  时间复杂度较高
         */
        // 备忘录，存储 used 数组的状态
        HashMap<String, Boolean> memo3 = new HashMap<>();
        public boolean canPartitionKSubsets3(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;

            boolean[] used = new boolean[nums.length];
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack3(k, 0, nums, 0, used, target);
        }
        private boolean backtrack3(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
            // 结束条件
            if (k == 0) {
                return true;
            }
            // 当前桶装满了，递归一下个桶
            if (bucket == target) {
                boolean result = backtrack3(k - 1, 0, nums, 0, used, target);
                // 记录当前桶 已经装满的状态
                memo3.put(Arrays.toString(used), result);
                return result;
            }

            // 使用备忘录 判断
            if (memo3.containsKey(Arrays.toString(used))) {
                return memo3.get(Arrays.toString(used));
            }

            // 选择集
            for (int i = start; i < nums.length; i++) {
                // 已经使用过了
                if (used[i]) {
                    continue;
                }

                if (bucket + nums[i] > target) {
                    continue;
                }

                // 做选择
                bucket += nums[i];
                used[i] = true;
                // 递归
                if (backtrack3(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                bucket -= nums[i];
                used[i] = false;

            }
            return false;
        }
        /**
         * 以桶为视角，那么每个数字 可选择 放入 或 不放入 这个桶
         * 时间复杂度 o(k*2^n)
         * 使用备忘录记录结果
         * 备忘录key: 使用 位图 作为key
         */
        // 备忘录，存储 used 数组的状态
        HashMap<Integer, Boolean> memo = new HashMap<>();
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;

            int used = 0;
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack4(k, 0, nums, 0, used, target);
        }
        private boolean backtrack4(int k, int bucket, int[] nums, int start,int used, int target) {
            // 结束条件
            if (k == 0) {
                return true;
            }
            // 当前桶装满了，递归一下个桶
            if (bucket == target) {
                boolean result = backtrack4(k - 1, 0, nums, 0, used, target);
                // 记录当前桶 已经装满的状态
                memo.put(used, result);
                return result;
            }

            // 使用备忘录 判断
            if (memo.containsKey(used)) {
                return memo.get(used);
            }

            // 选择集
            for (int i = start; i < nums.length; i++) {
                // 已经使用过了
                if (((used >> i) & 1) == 1) {
                    continue;
                }

                if (bucket + nums[i] > target) {
                    continue;
                }

                // 做选择
                bucket += nums[i];
                used |= (1 << i);
                // 递归
                if (backtrack4(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                bucket -= nums[i];
                used ^= (1 << i);

            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
