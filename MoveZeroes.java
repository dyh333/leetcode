/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30202
 *
 * [283] 移动零
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MoveZeroes {

    // @lc code=start
    class Solution {
        public void moveZeroes(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }

                fast++;
            }

            while (slow < nums.length) {
                nums[slow] = 0;
                slow++;
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [0,1,0,3,12]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */
