package nowCodeAlgorithm;


import java.util.EmptyStackException;

public class ArrayQueue {
    private int size = 0;
    private int[] array;
    private int capacity;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void enQueue(int num){
        if(size == capacity) throw new RuntimeException("The queue is full");
        array[tail] = num;
        tail = (tail + 1) % capacity;
        size++;
    }

    public int deQueue(){
        if(size == 0) throw new RuntimeException("The queue is empty");
        int res = array[head];
        head = (head + 1) % capacity;
        size--;
        return res;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
//        queue.enQueue(4);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
