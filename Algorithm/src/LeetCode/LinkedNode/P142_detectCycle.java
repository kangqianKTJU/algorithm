package LeetCode.LinkedNode;

import LeetCode.Common.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 */
public class P142_detectCycle {

    // 1. HashSet法
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if(head == null) return head;

        while(head != null){
            if(set.add(head)){
                head = head.next;
            }else{
                return head;
            }
        }
        return null;
    }

    // 2. 快慢指针（Floyd算法）
    // 先通过快慢指针找到相遇点，再将慢指针指到节点，和块指针同时走，两者相遇的点就是环的入口节点
    public ListNode detectCycle1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != head){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
