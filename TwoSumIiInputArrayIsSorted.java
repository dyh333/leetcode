/*
 * @lc app=leetcode.cn id=167 lang=java
 * @lcpr version=30202
 *
 * [167] 两数之和 II - 输入有序数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSumIiInputArrayIsSorted {

    // @lc code=start
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return new int[] { left + 1, right + 1 };
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here

        int[] numbers = new int[] { 3, 24, 50, 79, 88, 150, 345 };
        int target = 200;
        int[] res = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(res)); // Output: [2, 5]
    }
}

/*
 * // @lcpr case=start
 * // [2,7,11,15]\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,4]\n6\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,0]\n-1\n
 * // @lcpr case=end
 * 
 */
