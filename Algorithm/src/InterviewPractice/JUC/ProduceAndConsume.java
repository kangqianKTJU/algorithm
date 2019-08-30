package InterviewPractice.JUC;




import java.util.LinkedList;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

public class ProduceAndConsume {
    public static BlockingQueue queue = new ArrayBlockingQueue(3);
    public static Basket basket = new Basket(queue);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer(basket);
        Consumer consumer = new Consumer(basket);
        Consumer consumer2 = new Consumer(basket);
        service.execute(producer);
        service.execute(consumer);
        service.execute(consumer2);
    }
}

class Producer implements Runnable{
    Basket basket;
    public Producer(Basket basket){
        this.basket = basket;
    }
    @Override
    public void run() {
        int i = 0;
        Random rand = new Random(5000);
        while(true){
            basket.produce(i);
            try {
                long time = (long)rand.nextInt(3000) + 2000;
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

class Consumer implements Runnable{
    Basket basket;
    public Consumer(Basket basket){
        this.basket = basket;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(basket.consume());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Basket<E> {
    BlockingQueue<E> basket;
    public Basket(BlockingQueue basket){
        this.basket = basket;
    }

    public void produce(E name){
        try {
            basket.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public E consume(){
        E res = null;
        try {
            res = basket.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
}