package nowCodeAlgorithm;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack {
    private int capacity;
    public int size = 0;
    private int[] array = null;

    public ArrayStack(int capacity){
        array = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int num){
        if(size == capacity){
            throw new RuntimeException("stack  is full");
        }else{
            array[size++] = num;
        }
    }

    public int pop(){
        if(size == 0) throw new EmptyStackException();
        return array[--size];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
