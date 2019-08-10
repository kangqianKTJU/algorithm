package nowCoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class PrintFromTopToBottom_22 {

    // 1. 利用队列的先进先出的特性
    // 2. 遍历完根节点后，因为左右子树的遍历是由先后顺序的，将左右子树的根节点按照遍历的顺序先后入队，
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        queue.add(root);

        while(queue.size() > 0){
             TreeNode temp = queue.pollFirst();
             res.add(temp.val);
             if(temp.left != null){
                 queue.addLast(root.left);
             }
             if(temp.right != null){
                 queue.addLast(root.right);
             }
        }
        return res;
    }
}
