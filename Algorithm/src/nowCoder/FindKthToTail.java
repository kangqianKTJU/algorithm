package nowCoder;

import java.awt.geom.QuadCurve2D;
import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {


    // 1. 直接法
    //   1. 先遍历一遍列表，获取链表的长度
    //   2. 定位倒数第k个元素在链表的顺序位置，遍历列表，获取到该元素
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k < 0) return head;

        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        if(k > count){
            throw new IllegalArgumentException("k is large than the size of LikedList");
        }

        cur = head;
        for(int i = 0; i < count - k ; ++i){
            cur = cur.next;
        }
        return cur;
    }


    //2. 快慢指针法
    //  1. 使用快指针先走一段路，保证快指针走到null的时候，慢指针正好走到倒数第k个节点
    //  2. 快慢指针一起，直到快指针走到null;
    public ListNode FindKthToTail1(ListNode head,int k) {
        if(head == null || k < 0) return head;

        ListNode slow = head;
        ListNode quick = head;

        for(int i = 0; i < k; i++){
            if(quick == null) return  null;
            quick = quick.next;
        }

        while(quick != null){
            quick = quick.next;
            slow = slow.next;
        }

        return slow;
    }

    // 3. 通过栈来改变原链表的顺序
    public ListNode FindKthToTail2(ListNode head,int k) {
        if(head == null || k < 0) return head;
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        ListNode res = null;
        for(int i = 0; i < k; i++){
            if(stack.size() == 0){
                return null;
            }
            res = stack.pop();
        }
        return res;
    }
}
