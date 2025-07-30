/*
 * @lc app=leetcode.cn id=26 lang=java
 * @lcpr version=30202
 *
 * [26] 删除有序数组中的重复项
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    // @lc code=start
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    // 先往前走一步，再把非重复项填入
                    slow++;
                    nums[slow] = nums[fast];
                }

                fast++;
            }

            return slow + 1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,2,2,3,3,4]\n
// @lcpr case=end

 */

