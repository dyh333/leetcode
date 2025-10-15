/*
 * @lc app=leetcode.cn id=315 lang=java
 * @lcpr version=30202
 *
 * [315] 计算右侧小于当前元素的个数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CountOfSmallerNumbersAfterSelf {

    // @lc code=start
    class Solution {
        private int[] counts;
        private int[] indexes;

        public List<Integer> countSmaller(int[] nums) {
            counts = new int[nums.length];
            indexes = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indexes[i] = i;
            }
            merge_sort(nums, 0, nums.length - 1);
            List<Integer> res = new ArrayList<>();
            for (int c : counts) res.add(c);
            return res;
        }

        void merge_sort(int[] nums, int left, int right) {
            if (left >= right) return;
            int mid = (left + right) / 2;
            merge_sort(nums, left, mid);
            merge_sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

        void merge(int[] nums, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int[] tempIndexes = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;
            int rightCount = 0;
            while (i <= mid && j <= right) {
                if (nums[indexes[j]] < nums[indexes[i]]) {
                    tempIndexes[k] = indexes[j];
                    temp[k++] = nums[indexes[j++]];
                    rightCount++;
                } else {
                    counts[indexes[i]] += rightCount;
                    tempIndexes[k] = indexes[i];
                    temp[k++] = nums[indexes[i++]];
                }
            }
            while (i <= mid) {
                counts[indexes[i]] += rightCount;
                tempIndexes[k] = indexes[i];
                temp[k++] = nums[indexes[i++]];
            }
            while (j <= right) {
                tempIndexes[k] = indexes[j];
                temp[k++] = nums[indexes[j++]];
            }
            for (int t = 0; t < temp.length; t++) {
                indexes[left + t] = tempIndexes[t];
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        // put your test code here
        int[] nums = { 5, 2, 6, 1 };
        List<Integer> counts = solution.countSmaller(nums);
        System.out.println(counts); // Expected output: [2, 1, 1, 0]
        
    }
}



/*
// @lcpr case=start
// [5,2,6,1]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n
// @lcpr case=end

// @lcpr case=start
// [-1,-1]\n
// @lcpr case=end

 */

