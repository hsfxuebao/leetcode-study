package leetcode.editor.cn;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 
//
// 👍 2110, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author hsfxuebao
 * 2023-05-11 19:48:24 
 */
class P139_WordBreak{
    public static void main(String[] args) {
        Solution solution = new P139_WordBreak().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        Set<String> wordDict;
        // 是否找到
        boolean res = false;
        // 路径
        LinkedList<String> track = new LinkedList<>();
        // 备忘录
        int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.wordDict = new HashSet<>(wordDict);
        this.memo = new int[s.length()];
        // -1 表示未计算，0表示false  1表示true
        Arrays.fill(memo, -1);
        return backtrack1(s, 0);

    }
        private boolean backtrack1(String s, int i) {

            if (i == s.length()) {
                return true;
            }

            // 内存中判断
            if (memo[i] != -1) {
                return memo[i] == 0 ? false : true;
            }

            // 选择集 设 wordDict 的长度为 M，字符串 s 的长度为 N
            // 由于M > N 所以可以写成这样
            // 此时复杂度为 o(2^N * N^2)
            // 遍历 s[i..] 的所有前缀
            for (int j = 1; i+j <= s.length(); j++) {
                //
                if (wordDict.contains(s.substring(i, i + j))) {
                    // 回溯
                    boolean result = backtrack1(s, i+j);
                    if (result) {
                        memo[i] = 1;
                        return true;
                    }
                }
            }
            // s[i ..] 无法被拼出
            memo[i] = 0;
            return false;
        }


        /**
         * 还是会超时，可以使用备忘录
         */
        private void backtrack(String s, int i) {
            if (res) {
                return;
            }
            if (i == s.length()) {
                res = true;
                return;
            }

            // 选择集 设 wordDict 的长度为 M，字符串 s 的长度为 N
            // 时间复杂度：递归次数*单次递归时间复杂度 o(2^n*MN)
//            for (String word : wordDict) {
//                int length = word.length();
//                // 找到一个单词
//                if (i + length <= s.length()
//                        && s.substring(i, i + length).equals(word)) {
//                    // 记录选择
//                    track.add(word);
//                    // 递归
//                    backtrack(s, i+length);
//                    // 删除选择
//                    track.removeLast();
//                }
//            }
            // 由于M > N 所以可以写成这样
            // 此时复杂度为 o(2^N * N^2)
            for (int j = 1; i+j <= s.length(); j++) {
                //
                if (wordDict.contains(s.substring(i, i + j))) {
                    // 回溯
                    backtrack(s, i+j);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
