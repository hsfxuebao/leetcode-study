package leetcode.editor.cn;

//给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。 
//
// 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "tree"
//输出: "eert"
//解释: 'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入: s = "cccaaa"
//输出: "cccaaa"
//解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入: s = "Aabb"
//输出: "bbAa"
//解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s 由大小写英文字母和数字组成 
// 
//
// Related Topics哈希表 | 字符串 | 桶排序 | 计数 | 排序 | 堆（优先队列） 
//
// 👍 496, 👎 0 
//
//
//
//

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 根据字符出现频率排序
 *
 * @author hsfxuebao
 * 2023-09-20 19:38:01 
 */
class P451_SortCharactersByFrequency{
    public static void main(String[] args) {
        Solution solution = new P451_SortCharactersByFrequency().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> val2FreMap = new HashMap<>();
        Queue<WordFre> queue = new PriorityQueue<>(new Comparator<WordFre>() {
            @Override
            public int compare(WordFre o1, WordFre o2) {
                // 按照频率 降序  排序
                return o2.getFre() - o1.getFre();
            }
        });

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer oldVal = val2FreMap.getOrDefault(ch, 0);
            val2FreMap.put(ch, oldVal+1);
        }

        for (Map.Entry<Character, Integer> wordMap : val2FreMap.entrySet()) {
            char word = wordMap.getKey();
            Integer fre = wordMap.getValue();
            queue.offer(new WordFre(word, fre));
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            WordFre wordFre = queue.poll();
            char ch = wordFre.getWord();
            int fre = wordFre.getFre();
            while (fre > 0) {
                builder.append(ch);
                fre--;
            }
        }
        return builder.toString();

    }


        public class WordFre {
            char word;
            int fre;

            public WordFre(char word, int fre) {
                this.word = word;
                this.fre = fre;
            }

            public char getWord() {
                return word;
            }

            public void setWord(char word) {
                this.word = word;
            }

            public int getFre() {
                return fre;
            }

            public void setFre(int fre) {
                this.fre = fre;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
