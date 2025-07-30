/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到倒数第n+1个节点
        // dingyihui: 第一个参数应该是dummy, 否则findFromEnd中for循环可能导致空指针异常
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;

        return dummy.next;
    }
}
// @lc code=end
