package LeetCode.LinkedNode;

import LeetCode.Common.ListNode;

public class P328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead.next;
        ListNode mount = cur;
        int index = 1;
        while(cur != null && index % 2 == 1){

        }
        return null;
    }
}
