package leetcode.editor.cn;

//给定一个字符串 s 和一个字符串字典
// wordDict ，在字符串
// s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
//
// Related Topics字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 | 回溯 
//
// 👍 689, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分 II
 *
 * @author hsfxuebao
 * 2023-05-11 20:19:48 
 */
class P140_WordBreakIi{
    public static void main(String[] args) {
        Solution solution = new P140_WordBreakIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // 计算结果
        List<String> result = new ArrayList<>();
        Set<String> wordDict;
        // 记录 路径
        LinkedList<String> track = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        this.wordDict = new HashSet<>(wordDict);
        backtrack(s, 0);
        return result;

    }

        private void backtrack(String s, int i) {

            // base case
            if (i == s.length()) {
                result.add(String.join(" ", track));
                return;
            }

            // 选择集
            for (String word : wordDict) {
                int length = word.length();
                if (i + length <= s.length()
                        && s.substring(i, i + length).equals(word)) {
                    // 选择
                    track.add(word);
                    // 递归
                    backtrack(s, i+length);
                    // 撤销选择
                    track.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
