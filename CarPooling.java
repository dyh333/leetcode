/*
 * @lc app=leetcode.cn id=1094 lang=java
 * @lcpr version=30202
 *
 * [1094] 拼车
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CarPooling {
    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 给闭区间 [i, j] 增加 val（可以是负数）
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    // @lc code=start
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // nums 初始化为全 0
            int[] nums = new int[1000];
            // 构造差分解法
            Difference df = new Difference(nums);

            for (int[] trip : trips) {
                // 第trip[1]站乘客上车
                int i = trip[1];
                // 第trip[2]站乘客已经下车
                // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
                int j = trip[2] - 1;
                int val = trip[0];

                // 对区间 nums[i..j] 增加 val
                df.increment(i, j, val);
            }

            int[] res = df.result();
            for (int i = 0; i < res.length; i++) {
                if (res[i] > capacity) {
                    return false;
                }
            }
            
            return true;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
        // put your test code here
        int[][] trips1 = { { 2, 1, 5 }, { 3, 5, 7 } };
        int capacity1 = 3;
        System.out.println(solution.carPooling(trips1, capacity1)); // false
    }
}

/*
 * // @lcpr case=start
 * // [[2,1,5],[3,3,7]]\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[2,1,5],[3,3,7]]\n5\n
 * // @lcpr case=end
 * 
 */
