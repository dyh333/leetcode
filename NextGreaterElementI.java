/*
 * @lc app=leetcode.cn id=496 lang=java
 * @lcpr version=30202
 *
 * [496] 下一个更大元素 I
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NextGreaterElementI {

    // @lc code=start
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 记录 nums2 中每个元素的下一个更大元素
            int[] greater = nextGreaterElement(nums2);
            // 转化成映射：元素 x -> x 的下一个最大元素
            HashMap<Integer, Integer> greaterMap = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                greaterMap.put(nums2[i], greater[i]);
            }
            // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = greaterMap.get(nums1[i]);
            }
            return res;
        }

        // 计算 nums 中每个元素的下一个更大元素
        private int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            // 存放答案的数组
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            // 倒着往栈里放
            for (int i = n - 1; i >= 0; i--) {
                // 判定个子高矮
                while (!s.isEmpty() && s.peek() <= nums[i]) {
                    // 矮个起开，反正也被挡着了。。。
                    s.pop();
                }
                // nums[i] 身后的下一个更大元素
                res[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
            return res;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        // put your test code here
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}



/*
// @lcpr case=start
// [4,1,2]\n[1,3,4,2].\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n[1,2,3,4].\n
// @lcpr case=end

 */

