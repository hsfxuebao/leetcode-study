<p>给定两个字符串<code>s1</code>&nbsp;和&nbsp;<code>s2</code>，返回 <em>使两个字符串相等所需删除字符的&nbsp;<strong>ASCII&nbsp;</strong>值的最小和&nbsp;</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> s1 = "sea", s2 = "eat"
<strong>输出:</strong> 231
<strong>解释:</strong> 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> s1 = "delete", s2 = "leet"
<strong>输出:</strong> 403
<strong>解释:</strong> 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>0 &lt;= s1.length, s2.length &lt;= 1000</code></li> 
 <li><code>s1</code>&nbsp;和&nbsp;<code>s2</code>&nbsp;由小写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 316, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=minimum-ascii-delete-sum-for-two-strings" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题本质上是考察最长公共子序列问题的解法，把 [1143. 最长公共子序列问题](/problems/longest-common-subsequence) 的解法代码稍微改一下就 OK 了。

**详细题解：[经典动态规划：最长公共子序列](https://labuladong.github.io/article/fname.html?fname=LCS)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    // 备忘录
    int memo[1001][1001];

    /* 主函数 */
    int minimumDeleteSum(string s1, string s2) {
        int m = s1.size(), n = s2.size();
        // 备忘录值为 -1 代表未曾计算
        memset(memo, -1, sizeof(memo));
        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(string s1, int i, string s2, int j) {
        int res = 0;
        // base case
        if (i == s1.size()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.size(); j++)
                res += s2[j];
            return res;
        }
        if (j == s2.size()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.size(); i++)
                res += s1[i];
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1[i] == s2[j]) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                    s1[i] + dp(s1, i + 1, s2, j),
                    s2[j] + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        # 备忘录值为 -1 代表未曾计算
        memo = [[-1] * n for _ in range(m)]

        def dp(i: int, j: int) -> int:
            res = 0
            # base case
            if i == m:
                # 如果 s1 到头了，那么 s2 剩下的都得删除
                for k in range(j, n):
                    res += ord(s2[k])
                return res
            if j == n:
                # 如果 s2 到头了，那么 s1 剩下的都得删除
                for k in range(i, m):
                    res += ord(s1[k])
                return res

            if memo[i][j] != -1:
                return memo[i][j]

            if s1[i] == s2[j]:
                # s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
                memo[i][j] = dp(i + 1, j + 1)
            else:
                # s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
                memo[i][j] = min(
                    ord(s1[i]) + dp(i + 1, j),
                    ord(s2[j]) + dp(i, j + 1)
                )
            return memo[i][j]

        return dp(0, 0)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    // 备忘录
    int memo[][];

    /* 主函数 */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minimumDeleteSum(s1 string, s2 string) int {
    m, n := len(s1), len(s2)
    // 备忘录值为 -1 代表未曾计算
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }

    var dp func(s1 string, i int, s2 string, j int) int
    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    dp = func(s1 string, i int, s2 string, j int) int {
        res := 0
        // base case
        if i == len(s1) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for ; j < len(s2); j++ {
                res += int(s2[j])
            }
            return res
        }
        if j == len(s2) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for ; i < len(s1); i++ {
                res += int(s1[i])
            }
            return res
        }

        if memo[i][j] != -1 {
            return memo[i][j]
        }

        if s1[i] == s2[j] {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1)
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                int(s1[i]) + dp(s1, i + 1, s2, j),
                int(s2[j]) + dp(s1, i, s2, j + 1),
            )
        }
        return memo[i][j]
    }

    return dp(s1, 0, s2, 0)
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minimumDeleteSum = function(s1, s2) {
    var m = s1.length, n = s2.length;
    // memo[i][j] 存储将s1[i...]和s2[j...]删除成相同字符串的最小ASCII码之和
    var memo = new Array(m);
    for(var i=0; i<memo.length; i++) memo[i] = new Array(n).fill(-1);

    // dp函数定义，计算删除成相同字符所需的最小ASCII码之和
    function dp(i, j) {
        var res = 0;
        // 如果 s1 到头了，那么 s2 剩下的都得删除
        if (i == s1.length) {
            for (; j < s2.length; j++)
                res += s2.charCodeAt(j);
            return res;
        }
        // 如果 s2 到头了，那么 s1 剩下的都得删除
        if (j == s2.length) {
            for (; i < s1.length; i++)
                res += s1.charCodeAt(i);
            return res;
        }

        // 如果memo数组已有记录则直接返回
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 如果s1[i]和s2[j]都在LCS中，则不需要删除
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(i + 1, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，需要删掉一个
            memo[i][j] = Math.min(
                    s1.charCodeAt(i) + dp(i + 1, j),
                    s2.charCodeAt(j) + dp(i, j + 1)
            );
        }
        return memo[i][j];
    }

    // 返回将s1和s2删除成相同字符串的最小ASCII码之和
    return dp(0, 0);
};
```

</div></div>
</div></div>

**类似题目**：
  - [1143. 最长公共子序列 🟠](/problems/longest-common-subsequence)
  - [583. 两个字符串的删除操作 🟠](/problems/delete-operation-for-two-strings)
  - [剑指 Offer II 095. 最长公共子序列 🟠](/problems/qJnOS7)

</details>
</div>







