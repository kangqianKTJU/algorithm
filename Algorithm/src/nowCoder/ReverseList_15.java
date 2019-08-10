package nowCoder;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList_15 {

    //1. 递归法
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return  newHead;
    }

    // 2. 3个指针遍历反转
    public ListNode ReverseList1(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
