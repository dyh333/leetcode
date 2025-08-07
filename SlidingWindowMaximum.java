/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30202
 *
 * [239] 滑动窗口最大值
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SlidingWindowMaximum {

    // @lc code=start
    class Solution {
        // 单调队列的实现
        class MonotonicQueue {
            LinkedList<Integer> queue = new LinkedList<>();

            public void push(int n) {
                // 将小于 n 的元素全部删除：已经被压扁了
                while (!queue.isEmpty() && queue.getLast() < n) {
                    queue.pollLast();
                }
                // 然后将 n 加入尾部
                queue.addLast(n);
            }

            public void pop(int n) {
                // 如果想删除的元素已经被压扁了，即已经不在队列中，就不需要处理
                if(queue.getFirst() == n) {
                    queue.pollFirst();
                }
            }

            public int max() {
                return queue.getFirst();
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    // 先填满窗口的前 k - 1
                    window.push(nums[i]);
                } else {
                    // 窗口向前滑动，加入新数字
                    window.push(nums[i]);
                    // 记录当前窗口的最大值
                    res.add(window.max());
                    // 移出旧数字
                    window.pop(nums[i - k + 1]);
                }
            }

            int[] arr = new int[res.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }

            return arr;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // put your test code here
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3; // 窗口大小
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]

    }
}

/*
 * // @lcpr case=start
 * // [1,3,-1,-3,5,3,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 */
