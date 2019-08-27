package LeetCode.LinkedNode;


import LeetCode.Common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class P141_hasCycle {

    // 1. 双指针法
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 2. HashSet判断重复
    public boolean hasCycle1(ListNode head) {
        Set set = new HashSet();
        ListNode current = head;
        while (current != null && !set.contains(current)){
            set.add(current);
            current = current.next;
        }
        if (current == null) {
            return false;
        } else {
            return true;
        }
    }
}
