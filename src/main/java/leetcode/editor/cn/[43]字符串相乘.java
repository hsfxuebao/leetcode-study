package leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics数学 | 字符串 | 模拟 
//
// 👍 1218, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 字符串相乘
 *
 * @author hsfxuebao
 * 2023-06-17 08:25:31 
 */
class P43_MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new P43_MultiplyStrings().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {



        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // 高位
                int p1 = i+j;
                // 低位
                int p2 = i+j+1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 低位相加有可能超过10
                sum += result[p2];
                result[p2] = sum %10;
                result[p1] += sum/10;
            }
        }

        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
