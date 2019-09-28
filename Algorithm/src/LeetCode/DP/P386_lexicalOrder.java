package LeetCode.DP;

import java.util.LinkedList;
import java.util.List;

public class P386_lexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        for(int i = 1; i <= 9; i++){
            searcForNum(i, n, res);
        }
        return res;

    }

    private void searcForNum(int index, int n, List<Integer> res){
        LinkedList<Integer> queue = new LinkedList<>();
        if(index > n) return;
        queue.addLast(index);
        while(!queue.isEmpty()){
            int val =  queue.pollFirst();
            res.add(val);
            for (int i = 9; i >= 0; i--) {
                int temp = val * 10 + i;
                if(temp <= n) queue.addFirst(temp);
            }
        }
    }

    public static void main(String[] args) {
        P386_lexicalOrder solver = new P386_lexicalOrder();
        List<Integer> res = solver.lexicalOrder(100);
        for (Integer val:res){
            System.out.println(val);
        }
    }
}
