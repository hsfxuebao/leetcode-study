package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2455, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author hsfxuebao
 * 2023-05-14 09:38:34 
 */
class P17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public List<String> res = new ArrayList<>();
        public String[] mapping = new String[]{"","","abc","def",
                "ghi","jkl","mno","pqrs","tuv","wxyz"};
        /**
         * 回溯算法
         */
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return res;
        }

        StringBuilder track = new StringBuilder();
        backtrack(digits, 0, track);
        return res;
    }

        private void backtrack(String digits, int start, StringBuilder track) {

            // 终止条件
            if (track.length() == digits.length()) {
                res.add(track.toString());
                return;
            }

            // 选择集
            for (int i = start; i < digits.length(); i++) {
                char c = digits.charAt(i);
                // 字符c 对应可选择的字母集
                char[] chs = mapping[c - '0'].toCharArray();
                for (char ch : chs) {
                    // 选择
                    track.append(ch);
                    // 递归
                    backtrack(digits, i+1, track);
                    // 撤销选择
                    track.deleteCharAt(track.length()-1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
