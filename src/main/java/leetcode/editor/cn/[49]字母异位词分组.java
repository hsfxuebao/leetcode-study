package leetcode.editor.cn;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 1485, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author hsfxuebao
 * 2023-05-12 21:04:47 
 */
class P49_GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49_GroupAnagrams().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            // 对str进行编码
            String encode = encode(str);
            group.putIfAbsent(encode, new ArrayList<>());
            group.get(encode).add(str);
        }

        // 返回结果

        List<List<String>> collect = group.values().stream().collect(Collectors.toList());
        return collect;

    }

        private String encode(String str) {

            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                int index = c - 'a';
                count[index]++;
            }
            return new String(count);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
