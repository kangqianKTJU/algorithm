package nowCoder;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop_55 {


    // 1. 快慢指针法
    //    1. 先通过快慢指针确定有没有环，如果快指针能走到null,则没有环
    //    2. 没有环的话，快慢指针最后一定会相遇的，
    //    3. 相遇后确定有环之后，再去确定环的长度
    //    4. 保持一个指针不动，另一个指针动起来，直到两个指针相遇，统计环中的节点数目
    //    5. 然后，快慢指针都指向头节点，快指针先走换的长度个节点。慢指针再开始行走，两者相遇的节点就是入口。
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;

        ListNode slow  = pHead;
        ListNode quick = pHead.next;
        while(slow != quick){
            if(quick == null || quick.next == null) return null;
            slow = slow.next;
            quick = quick.next.next;
        }
        int n = 1;
        quick = quick.next;
        while(slow != quick){
            ++n;
            quick = quick.next;
        }

        slow  = pHead;
        quick = pHead;
        for(int i = 0; i < n; ++i){
            quick = quick.next;
        }

        while(slow != quick){
            slow= slow.next;
            quick = quick.next;
        }
        return slow;
    }

    //2. 如果快慢指针满足2倍速度的关系时，相遇点到链表入口的距离正好是起始点到链表入口的距离
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;
        ListNode slow  = pHead.next;
        ListNode quick = pHead.next.next;
        while(slow != quick){
            if(quick == null || quick.next == null) return null;
            slow = slow.next;
            quick = quick.next.next;
        }
        slow  = pHead;
        while(slow != quick){
            slow= slow.next;
            quick = quick.next;
        }
        return slow;

    }
}
