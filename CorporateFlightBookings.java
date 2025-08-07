/*
 * @lc app=leetcode.cn id=1109 lang=java
 * @lcpr version=30202
 *
 * [1109] 航班预订统计
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CorporateFlightBookings {

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
        public int[] corpFlightBookings(int[][] bookings, int n) {
            // nums 初始化为全 0
            int[] nums = new int[n];
            // 构造差分解法
            Difference df = new Difference(nums);

            for (int[] booking : bookings) {
                // 注意转成数组索引要减一
                int i = booking[0] - 1;
                int j = booking[1] - 1;
                int val = booking[2];

                // 对区间 nums[i..j] 增加 val
                df.increment(i, j, val);
            }

            return df.result();
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
        // put your test code here
        int[][] bookings1 = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n1 = 5;
        System.out.println(Arrays.toString(solution.corpFlightBookings(bookings1, n1))); // [10, 55, 45, 25, 25]

    }
}

/*
 * // @lcpr case=start
 * // [[1,2,10],[2,3,20],[2,5,25]]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,10],[2,2,15]]\n2\n
 * // @lcpr case=end
 * 
 */
