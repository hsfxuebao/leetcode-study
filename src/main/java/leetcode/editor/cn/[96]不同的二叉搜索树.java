package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)


class Solution {

    int[][] count;

    public int numTrees(int n) {

        if (n <= 0) {
            return 0;
        }
        // 初始化 都为0
        count = new int[n + 1][n + 1];
        return countV2(1, n);
    }

    private int countV2(int left, int right) {
        if (left > right) {
            return 1;
        }
        // 从备忘录 中取数据
        if (count[left][right] > 0) {
            return count[left][right];
        }

        int res = 0;
        for (int i = left; i <= right; i++) {
            // i为值作为根节点root
            // 左子树
            int leftCnt = countV2(left, i - 1);
            // 右子树
            int rightCnt = countV2(i + 1, right);
            res += leftCnt * rightCnt;
        }
        // 记录到 备忘录中
        count[left][right] = res;
        return res;


    }

    /**
     * 从 闭区间 left 到right之间可能构造多少种二叉搜索树
     * todo 会超时
     */
    private int count(int left, int right) {

        if (left > right) {
            return 1;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            // i为值作为根节点root
            // 左子树
            int leftCnt = count(left, i - 1);
            // 右子树
            int rightCnt = count(i + 1, right);
            res += leftCnt * rightCnt;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
