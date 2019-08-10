package nowCoder;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

// 1. 定义辅助栈，每次压栈的时候，若该元素比栈顶的元素小，则同时把该元素压入辅助栈；若不小于，则把栈顶的元素复制一遍压栈。

public class StackWithMin_20 {

    Stack<Integer> numStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        numStack.push(node);
        if(minStack.size() == 0 || node < minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(numStack.size() > 0 && minStack.size() > 0){
            numStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return  numStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}


// 2. 每次将当前遇到的最小元素压入辅助栈，弹出栈的时候，检查栈顶的元数是否等于辅助栈的栈顶元素，若相等，则辅助栈也弹出，否则，只是
//   获取栈顶的元素，不弹出。
class StackWithMin_20_2{
    private LinkedList<Integer> numStack = new LinkedList();
    private LinkedList<Integer> minStack = new LinkedList();

    public void push(int node) {
        if(numStack.size() == 0)
            minStack.addFirst(node);
        else
        if(node < minStack.getFirst()){
            minStack.addFirst(node);
        }
        numStack.addFirst(node);
    }

    public void pop() {
        if(numStack.getFirst() == minStack.getFirst()){
            minStack.pollFirst();
        }
        numStack.pollFirst();
    }

    public int top() {
        return numStack.getFirst();
    }

    public int min() {

        return minStack.getFirst();
    }
}
