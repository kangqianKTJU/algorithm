package nowCodeAlgorithm;

public class ArrayQueue1 {
    private int capacity;
    private int[] array;
    private int head;
    private int tail;

    public ArrayQueue1(int capacity){
        array = new int[capacity + 1];
        this.capacity = capacity + 1;
    }

    public void enQueue(int num){
        if(((tail + 1) % capacity) == head) throw new RuntimeException("The queue is full");
        array[tail] = num;
        tail = (tail + 1) % capacity;
    }

    public int deQueue(){
        if(tail == head) throw new RuntimeException("The queue is empty");
        int res = array[head];
        head = (head + 1) % capacity;
        return res;
    }

    public static void main(String[] args) {
        ArrayQueue1 queue = new ArrayQueue1(3);
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
