package LeetCode.Tree;

import LeetCode.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class P94_inorderTraversal{


    // 1. 递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalRc(root, res);
        return res;
    }
    private void inorderTraversalRc(TreeNode node, List<Integer> res){
        if(node == null) return;
        inorderTraversalRc(node.left, res);
        res.add(node.val);
        inorderTraversalRc(node.right, res);
    }

    // 2. 迭代法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        if(cur == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
