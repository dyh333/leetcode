/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

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
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }
        
        // 断开与后面重复元素的链接
        slow.next = null;

        return dummy.next;
    }
}
// @lc code=end

