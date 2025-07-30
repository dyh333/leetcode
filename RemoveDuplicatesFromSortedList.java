/*
 * @lc app=leetcode.cn id=83 lang=java
 * @lcpr version=30202
 *
 * [83] 删除排序链表中的重复元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedList {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 用dummy节点就不用处理head为空的特殊情况
            ListNode dummy = new ListNode(-999); // -100 <= Node.val <= 100
            dummy.next = head;
            
            ListNode slow = dummy, fast = dummy;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }

            slow.next = null;
            return dummy.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,3]\n
// @lcpr case=end

 */

