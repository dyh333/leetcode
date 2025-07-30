/*
 * @lc app=leetcode.cn id=344 lang=java
 * @lcpr version=30202
 *
 * [344] 反转字符串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseString {

    // @lc code=start
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                left++;
                right--;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// ["h","e","l","l","o"]\n
// @lcpr case=end

// @lcpr case=start
// ["H","a","n","n","a","h"]\n
// @lcpr case=end

 */

