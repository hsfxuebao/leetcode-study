package leetcode.editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics数学 | 字符串 | 模拟 
//
// 👍 803, 👎 0 
//
//
//
//

/**
 * 字符串相加
 *
 * @author hsfxuebao
 * 2023-11-17 10:10:10 
 */
class P415_AddStrings{
    public static void main(String[] args) {
        Solution solution = new P415_AddStrings().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int index1= num1.length() - 1;
        int index2 = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        // 进位
        int temp = 0;

        while (temp > 0 || index1 >= 0 || index2 >= 0) {

            int res = 0;
            if (index1 >= 0) {
                res += (num1.charAt(index1) - '0');
            }
            if (index2 >= 0) {
                res += (num2.charAt(index2) - '0');
            }
            res += temp;
            temp = res / 10;

            int num = res % 10;
            sb.append(num);
            index1--;
            index2--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
