/*
 * @lc app=leetcode.cn id=27 lang=java
 * @lcpr version=30202
 *
 * [27] 移除元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveElement {

    // @lc code=start
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            return slow;

        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [3,2,2,3]\n3\n
// @lcpr case=end

// @lcpr case=start
// [0,1,2,2,3,0,4,2]\n2\n
// @lcpr case=end

 */

