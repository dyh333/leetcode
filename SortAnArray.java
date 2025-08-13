/*
 * @lc app=leetcode.cn id=912 lang=java
 * @lcpr version=30202
 *
 * [912] 排序数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortAnArray {

    // @lc code=start
    class Solution {
        public int[] sortArray(int[] nums) {
            // 归并排序
            merge_sort(nums);

            return nums;
        }

        void merge_sort(int[] nums) {
            sort(nums, 0, nums.length - 1);
        }

        void sort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            int mid = (low + high) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

        void merge(int[] nums, int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;
            while (i <= mid && j <= high) {
                if (nums[i] < nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = nums[i++];
            }
            while (j <= high) {
                temp[k++] = nums[j++];
            }
            for (int t = 0; t < temp.length; t++) {
                nums[low + t] = temp[t];
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        // put your test code here
        int[] nums = { 5, 2, 3, 1 };
        int[] sorted = solution.sortArray(nums);
        System.out.println(Arrays.toString(sorted)); // Expected output: [1, 2, 3, 5]

    }
}

/*
 * // @lcpr case=start
 * // [5,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,1,1,2,0,0]\n
 * // @lcpr case=end
 * 
 */
