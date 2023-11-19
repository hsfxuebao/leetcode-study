package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1542, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author hsfxuebao
 * 2023-11-19 10:36:16 
 */
class P77_Combinations{
    public static void main(String[] args) {
        Solution solution = new P77_Combinations().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, 1, track, k);
        return res;
    }

        private void backtrack(int n, int startIndex, LinkedList<Integer> track, int k) {

            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }

            // 选择集
            for (int i = startIndex; i <= n; i++) {
                track.add(i);
                backtrack(n, i+1, track, k);
                track.removeLast();
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
