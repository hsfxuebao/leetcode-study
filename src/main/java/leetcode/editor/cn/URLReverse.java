package leetcode.editor.cn;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2024-01-02
 *
 * 字节面试遇到的一个算法题，url反转
 * 给你一个url，反转
 * 如https://www.baidu.com/dev-ops/question，反转后结果为https://question/ops-dev/com.baidu.www
 *
 */
class URLReverse {

    public static void main(String[] args) {
        URLReverse.Solution solution = new URLReverse().new Solution();
        String s = "https://www.baidu.com/dev-ops/question";
        String reverse = solution.reverse(s);
        System.out.println(reverse);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 空间复杂度o(n)
        public String reverse(String s) {

            // 跳过https://
            char[] chars = s.toCharArray();
            int pos = 0, cnt = 0;
            while (cnt < 2) {
                if (chars[pos] == '/') {
                    cnt++;
                }
                pos++;
            }

            // 反转 pos 到 最后的位置
            swap(chars, pos, s.length() - 1);
            // 遍历对于 . 或/ 在此翻转一下

            int temp = pos;
            for (int i = pos; i < chars.length; i++) {
                char ch = chars[i];
                if (ch == '.' || ch == '/' ||
                      ch == '-' || i == s.length() - 1) {
                    // 反转
                    swap(chars, temp, i-1);
                    temp = i+1;
                }
            }

            return String.valueOf(chars);
        }

        public void swap(char[] chars, int i, int j){
            while (i < j) {

                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
    }
}
