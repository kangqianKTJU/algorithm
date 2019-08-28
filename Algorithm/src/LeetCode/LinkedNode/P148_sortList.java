package LeetCode.LinkedNode;

import LeetCode.Common.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class P148_sortList {

    // 1.归并排序的思想
    //  1. 利用快慢指针将链表二分，一直二分到可以本身就是一个有序的链表为止
    //  2. 合并，有序链表的合并。
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fast =  head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode frontHead = sortList(head);
        ListNode afterHead = sortList(temp);

        ListNode newHead = mergeList(frontHead, afterHead);
        return newHead;
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode head = null;
        if(head1.val < head2.val){
            head = head1;
            head1 = head1.next;
        }else {
            head = head2;
            head2 = head2.next;
        }
        ListNode cur = head;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        if(head1 == null){
            cur.next = head2;
        }
        else{
            cur.next = head1;
        }
        return head;
    }


    public static void main(String[] args) {
        P148_sortList solver = new P148_sortList();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = solver.sortList(node1);
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


}
