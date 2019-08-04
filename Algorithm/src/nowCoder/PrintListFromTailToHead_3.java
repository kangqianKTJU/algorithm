package nowCoder;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */


public class PrintListFromTailToHead_3 {

    // 1. 显示利用栈结构
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null) return list;
         ListNode cur = listNode;

         while(cur != null){
             list.add(0, cur.val);
             cur = cur.next;
         }
         return list;
    }


    // 2. 利用递归栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode == null) return new ArrayList<>();
        ArrayList<Integer> list = printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}


