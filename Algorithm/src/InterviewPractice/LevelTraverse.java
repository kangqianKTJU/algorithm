package InterviewPractice;

import LeetCode.Common.ListNode;
import LeetCode.Common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

public class LevelTraverse {

    public void levelTraverse(TreeNode root){
        if(root == null) return;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair(root, 0));
        int deep = 0;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> temp = stack.pop();
            if(temp.getValue() != deep){
                System.out.println();
                deep++;
            }
            System.out.print(temp.getKey().val + " ");
            if(temp.getKey().left != null){
                stack.add(new Pair(temp.getKey().left, deep + 1));
            }
            if(temp.getKey().right != null){
                stack.add(new Pair(temp.getKey().right, deep + 1));
            }
        }
    }

    public static void main(String[] args) {
        LevelTraverse solver = new LevelTraverse();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        solver.levelTraverse(node1);

    }
}
