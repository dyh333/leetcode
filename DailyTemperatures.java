/*
 * @lc app=leetcode.cn id=739 lang=java
 * @lcpr version=30202
 *
 * [739] 每日温度
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DailyTemperatures {

    // @lc code=start
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            // 这里放元素索引，而不是元素
            Stack<Integer> stack = new Stack<>();

            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                // 得到索引间距
                res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
                // 将索引入栈，而不是元素
                stack.push(i);
            }

            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // put your test code here
        int[] temperatures = { 73, 74, 75, 71, 69, 76 };
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}

/*
 * // @lcpr case=start
 * // [73,74,75,71,69,72,76,73]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,40,50,60]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,60,90]\n
 * // @lcpr case=end
 * 
 */
