package LeetCode.DFS;
/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */

import LeetCode.Common.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class P98_isValidBST {

    // 1. 递归法
    //  先判断根节点的值是否比左子树的节点值都大，如果是的话，再看左子树是否也是有效的二叉搜索树，
    //  然后对右子树进行相同的操作
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        boolean leftFlag = true;
        boolean rightFlag = true;

        if(root.left != null){
            if(isBigger(root, root.left)){
                leftFlag = isValidBST(root.left);
            }else{
                return false;
            }
        }

        if(root.right != null){
            if(isSmaller(root, root.right)){
                rightFlag = isValidBST(root.right);
            }else{
                return false;
            }
        }

        return leftFlag && rightFlag;
    }

    private boolean isSmaller(TreeNode root, TreeNode rightChild){
        if(rightChild == null) return true;
        if(root.val >= rightChild.val) return false;

        boolean leftFlag = true;
        if(rightChild.left != null){
            leftFlag = isSmaller(root, rightChild.left);
        }

        boolean rightFlag = true;
        if(rightChild.right != null){
            rightFlag = isSmaller(root, rightChild.right);
        }

        return leftFlag && rightFlag;
    }


    private boolean isBigger(TreeNode root, TreeNode leftChild){
        if(leftChild == null) return true;
        if(root.val <= leftChild.val) return false;

        boolean leftFlag = true;
        if(leftChild.left != null){
            leftFlag = isBigger(root, leftChild.left);
        }

        boolean rightFlag = true;
        if(leftChild.right != null){
            rightFlag = isBigger(root, leftChild.right);
        }

        return leftFlag && rightFlag;
    }

    public static void main(String[] args) {
        P98_isValidBST solution = new P98_isValidBST();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

//        System.out.println(solution.isValidBST(node1));
        System.out.println(solution.isValidBST1(node1));
    }

    //2. 进行前序遍历，遍历结果看是否是有序的
    public boolean isValidBST1(TreeNode root) {
        if(root == null || (root.left == null && root.right == null));
        List<TreeNode> list = new ArrayList<>();
        preTraverse(root, list);

        for(int i = 1; i < list.size(); i++){
            if(list.get(i).val >= list.get(i - 1).val){
                return false;
            }
        }
        return true;
    }

    private void preTraverse(TreeNode node, List<TreeNode> path){

        if(node == null) return;
        if(node.left == null && node.right == null){
            path.add(node);
            return;
        }
        preTraverse(node.left, path);
        path.add(node);
        preTraverse(node.right, path);
    }

}
