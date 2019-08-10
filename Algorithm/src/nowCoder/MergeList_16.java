package nowCoder;

import sun.rmi.log.LogInputStream;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList_16 {

    // 1. 两个指针分别指向两个链表，比较当前值的大小，依此添加到新的链表中。
    public ListNode Merge(ListNode list1,ListNode list2){

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;


        while(l1 != null || l2 != null){
            if(l1 == null) {
                cur.next = list2;
                break;
            }
            if(l2 == null){
                cur.next = list1;
                break;
            }

            if(l1.val > l2.val){
                cur.next = new ListNode(l2.val); // 可以该表原节点的话，直接指向 l2
                l2 = l2.next;
                cur = cur.next;
            }else{
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur= cur.next;
            }
        }
        return dummyHead.next;
    }

    //2. 递归调用
    public ListNode Merge1(ListNode list1,ListNode list2){
        if(list1 == null) return  list2;
        if(list2 == null) return list1;

        ListNode newHead = new ListNode(-1);
        if(list1.val < list2.val){
            newHead = list1;
            newHead.next = Merge1(list1.next, list2);
        }else{
            newHead = list2;
            newHead.next = Merge1(list1, list2.next);
        }
        return newHead;
    }

}
