/*
 * @lc app=leetcode.cn id=303 lang=java
 * @lcpr version=30202
 *
 * [303] 区域和检索 - 数组不可变
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RangeSumQueryImmutable {

    // @lc code=start
    class NumArray {
        private int[] preSum;
    
        public NumArray(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算nums的累加和
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }
        
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
    
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
    // @lc code=end
    
    public static void main(String[] args) {
        int nums[] = { -2, 0, 3, -5, 2, -1 };
        // put your test code here
        NumArray numArray = new RangeSumQueryImmutable().new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));    // Output: 1
        System.out.println(numArray.sumRange(2, 5));    // Output: -1
        System.out.println(numArray.sumRange(0, 5));    // Output: -3
    }
}



/*
// @lcpr case=start
// ["NumArray", "sumRange", "sumRange", "sumRange"]\n[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]\n
// @lcpr case=end

 */

