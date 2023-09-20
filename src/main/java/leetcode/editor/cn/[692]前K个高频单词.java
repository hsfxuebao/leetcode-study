package leetcode.editor.cn;

//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。 
//
// 
//
// 示例 1： 
//
// 
//输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 
//k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] 由小写英文字母组成。 
// k 的取值范围是 [1, 不同 words[i] 的数量] 
// 
//
// 
//
// 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
//
// Related Topics字典树 | 哈希表 | 字符串 | 桶排序 | 计数 | 排序 | 堆（优先队列） 
//
// 👍 573, 👎 0 
//
//
//
//

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 前K个高频单词
 *
 * @author hsfxuebao
 * 2023-09-20 19:28:12 
 */
class P692_TopKFrequentWords{
    public static void main(String[] args) {
        Solution solution = new P692_TopKFrequentWords().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> val2FreMap = new HashMap<>();
        Queue<WordFre> queue = new PriorityQueue<>(new Comparator<WordFre>() {
            @Override
            public int compare(WordFre o1, WordFre o2) {
                if (o1.getFre() == o2.getFre()) {
                    // 按照字典序降序 排序
                    return o2.getWord().compareTo(o1.getWord());
                }
                return o1.getFre() - o2.getFre();
            }
        });

        for (int i = 0; i < words.length; i++) {
            Integer oldVal = val2FreMap.getOrDefault(words[i], 0);
            val2FreMap.put(words[i], oldVal+1);
        }
        for (Map.Entry<String, Integer> wordMap : val2FreMap.entrySet()) {
            String word = wordMap.getKey();
            Integer fre = wordMap.getValue();
            queue.offer(new WordFre(word, fre));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.addFirst(queue.poll().getWord());
        }
        return result;
    }

        public class WordFre {
            String word;
            int fre;

            public WordFre(String word, int fre) {
                this.word = word;
                this.fre = fre;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
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
