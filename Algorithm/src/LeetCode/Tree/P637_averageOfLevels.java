package LeetCode.Tree;

import LeetCode.Common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return null;

        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, 0));
        int rootLevel = 0;
        double sum = 0.0;
        int count = 0;
        List<Double> res = new ArrayList<>();
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> temp = stack.pop();
            if(temp.getValue() == rootLevel){
                sum += temp.getKey().val;
                ++count;
            }else{
                res.add(sum / count);


            }


        }

        return  res;
    }
}
