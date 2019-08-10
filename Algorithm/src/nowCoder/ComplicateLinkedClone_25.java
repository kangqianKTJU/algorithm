package nowCoder;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ComplicateLinkedClone_25 {
    // 1. 三步法
    //   1. 在每个节点的后面复制并连上这个复制后的节点
    //   2. 将原链表中的random关系按照偏移映射到复制后的节点之间
    //   3. 拆分两个列表，得到复制后的列表
    public RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead == null) return null;


       RandomListNode cur = pHead;
       while(cur != null){
           RandomListNode temp = cur.next;
           cur.next = new RandomListNode(cur.label);
           cur.next.next = temp;
           cur = temp;
       }

       cur = pHead;
       while(cur != null){
           if(cur.random != null){
               cur.next.random = cur.random.next;
           }
           cur = cur.next.next;
       }

       cur = pHead;
       RandomListNode newHead = cur.next;
       while(cur != null){
           RandomListNode temp = cur.next;
           cur.next = temp.next;
           if(cur.next != null){
               temp.next = temp.next.next;
           }else{
               temp.next = null;
           }
           cur = cur.next;
       }

       return newHead;
    }






    private static void print(RandomListNode pHead){
        if(pHead == null) return;

        RandomListNode cur = pHead;
        while(cur != null){
            System.out.print(cur.label + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ComplicateLinkedClone_25 solution = new ComplicateLinkedClone_25();

        RandomListNode node1 = new RandomListNode(0);
        RandomListNode node2 = new RandomListNode(1);
        RandomListNode node3 = new RandomListNode(2);
        RandomListNode node4 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node2.random = node3;

        print(node1);

        RandomListNode newHead = solution.Clone(node1);

        print(node1);

    }
}
