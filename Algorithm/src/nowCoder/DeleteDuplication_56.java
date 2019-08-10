package nowCoder;

public class DeleteDuplication_56 {

    /**
     * P56: 题目描述
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {

        if(pHead == null || pHead.next == null) return pHead;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode prev = dummyHead;
        ListNode cur = pHead;
        ListNode next = pHead.next;

        while (next != null) {
            boolean needDel = false;
            while(next != null && cur.val == next.val){
                needDel = true;
                next = next.next;
            }
            if(needDel){
                prev.next = next;
                cur = next;
                if(next != null) next = next.next;
            }else{
                prev = cur;
                cur = next;
                next = next.next;
            }
        }
        return dummyHead.next;
    }
}
