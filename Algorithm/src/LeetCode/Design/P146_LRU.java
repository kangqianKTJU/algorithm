package LeetCode.Design;

import javafx.util.Pair;


import javax.activation.MailcapCommandMap;
import javax.jws.soap.SOAPBinding;
import javax.security.auth.callback.CallbackHandler;
import java.rmi.Remote;
import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class P146_LRU {

    // 1. 简单查找更新移动 (使用链表)
    //  每次操作都要遍历整个list，查看是否有该元素，效率较低 O(n)
    //  插入：遍历列表， 存在该元素则删除该元素，在末尾添加更新的元素；
    //      若不存在，检查是否超过容量，若超过，移除尾部元素再添加新元素，否则直接添加新元素。
    //  获取： 若存在，获取后，将该元素删除，并重新插入到尾部。
    private LinkedList<Pair> queue = new LinkedList<>();
    private int capacity = 0;

    public P146_LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (queue.size() == 0) return -1;
        Pair<Integer, Integer> tempPair = getPair(key);
        if (tempPair != null) {
            queue.remove(tempPair);
            queue.addLast(tempPair);
            return tempPair.getValue();
        } else
            return -1;
    }

    public void put(int key, int value) {
        Pair<Integer, Integer> tempPair = getPair(key);
        if (tempPair != null) {
            queue.remove(tempPair);
        } else {
            if (queue.size() == capacity) {
                queue.removeFirst();
            }
        }
        queue.add(new Pair(key, value));
    }

    private Pair<Integer, Integer> getPair(int key) {
        if (queue.size() == 0) return null;

        for (Pair<Integer, Integer> tempPair : queue) {
            if (tempPair.getKey().equals(key)) {
                return tempPair;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        LRUCache solution = new LRUCache(2);
        solution.put(1,1);
        solution.put(2,2);
        System.out.println(solution.get(1));
        solution.put(3,3);
        System.out.println(solution.get(2));
        solution.put(4,4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
    }
}


// 2. 使用链表更新访问，使用Map更新缓存
class LRUCache {


    private int size = 0;
    private int capacity = 0;
    DLinkNode dummyHead;
    DLinkNode tail;
    HashMap<Integer, DLinkNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new DLinkNode(-1, -1);
        tail = new DLinkNode(-1, -1);
        dummyHead.next = tail;
        tail.prev = dummyHead;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode temp = cache.get(key);
            moveToHead(temp);
            return temp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode node = cache.get(key);
            node.setValue(value);
            moveToHead(node);
        } else {
            DLinkNode newNode = new DLinkNode(key, value);
            addNode(newNode);
            cache.put(key,newNode);
            if (capacity < size) {
                cache.remove(tail.prev.getKey());
                removeNode(tail.prev);
            }
        }
    }


    class DLinkNode {
        private int key;
        private int value;
        private DLinkNode next;
        private DLinkNode prev;

        DLinkNode(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }


    private void addNode(DLinkNode node) {
        // 在虚假节点头部添加元素

        node.next = dummyHead.next;
        node.prev = dummyHead;
        node.next.prev = node;
        dummyHead.next = node;
        size++;

    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        node.next = null;
        node.prev = null;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }


}

