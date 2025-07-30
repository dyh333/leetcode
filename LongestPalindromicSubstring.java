/*
 * @lc app=leetcode.cn id=5 lang=java
 * @lcpr version=30202
 *
 * [5] 最长回文子串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestPalindromicSubstring {

    // @lc code=start
    class Solution {
        public String palindrome(String s, int left, int right) {
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return s.substring(left + 1, right);
        }

        public String longestPalindrome(String s) {
            String res = "";

            for (int i = 0; i < s.length(); i++) {
                // 以s[i]为中心的奇数回文串
                String s1 = palindrome(s, i, i);
                // 以s[i], s[i+1]为中心的偶数回文串
                String s2 = palindrome(s, i, i + 1);

                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }

            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // put your test code here
        String s = "babad";
        String res = solution.longestPalindrome(s);
        System.out.println(res);
    }
}

/*
 * // @lcpr case=start
 * // "babad"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "cbbd"\n
 * // @lcpr case=end
 * 
 */
