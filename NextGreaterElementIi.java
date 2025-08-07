/*
 * @lc app=leetcode.cn id=503 lang=java
 * @lcpr version=30202
 *
 * [503] 下一个更大元素 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NextGreaterElementIi {

    // @lc code=start
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<Integer>();

            for (int i = n * 2 - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    stack.pop();
                }

                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            
            return res;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        // put your test code here
        int[] nums = { 1, 2, 3, 4, 3};
        int[] result = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [2, -1, 2]

    }
}

/*
 * // @lcpr case=start
 * // [1,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,3]\n
 * // @lcpr case=end
 * 
 */
