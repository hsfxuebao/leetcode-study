<p>输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[2,7] 或者 [7,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [10,26,30,31,47,60], target = 40
<strong>输出：</strong>[10,30] 或者 [30,10]
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10^5</code></li> 
 <li><code>1 &lt;= nums[i]&nbsp;&lt;= 10^6</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 二分查找</details><br>

<div>👍 250, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=he-wei-sde-liang-ge-shu-zi-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [1. 两数之和](/problems/two-sum) 基本一样，而且还说了 `nums` 是有序的，所以直接用 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中讲的左右双指针解决即可。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 左右双指针
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return {nums[left], nums[right]};
            }
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 左右双指针
        left, right = 0, len(nums) - 1
        while left < right:
            sum = nums[left] + nums[right]
            if sum < target:
                # 让和大一点
                left += 1
            elif sum > target:
                # 让和小一点
                right -= 1
            else:
                # 找到两个数
                return [nums[left], nums[right]]
        return None
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 左右双指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func twoSum(nums []int, target int) []int {
    // 左右双指针
    left, right := 0, len(nums)-1
    for left < right {
        sum := nums[left] + nums[right]
        if sum < target {
            // 让和大一点
            left++
        } else if sum > target {
            // 让和小一点
            right--
        } else {
            // 找到两个数
            return []int{nums[left], nums[right]}
        }
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var twoSum = function(nums, target) {
    // 左右双指针
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let sum = nums[left] + nums[right];
        if (sum < target) {
            // 让和大一点
            left++;
        } else if (sum > target) {
            // 让和小一点
            right--;
        } else {
            // 找到两个数
            return [nums[left], nums[right]];
        }
    }
    return null;
};
```

</div></div>
</div></div>

**类似题目**：
  - [两数之和 II - 输入有序数组](/problems/two-sum-ii-input-array-is-sorted/)
  - [删除有序数组中的重复项](#26)
  - [移除元素](#27)
  - [移动零](#283)
  - [反转字符串](/problems/reverse-string/)
  - [最长回文子串](#5)
  - [删除排序链表中的重复元素](#83)
  - [排序数组中两个数字之和](/problems/kLl5u1/)

</details>
</div>



