package nowCoder;

import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class MirrorTree_18 {
    // 1. 递归法
    //   1. 只要当前节点的左右子节点中有一个不为null，就交换左右节点
    //   2. 若左子树不为null，则进行递归调用，若右子树不为null，则进行递归调用
    public void Mirror(TreeNode root) {
        if(root == null) return;

        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = root.left;
        }

        if(root.left != null)
            Mirror(root.left);
        if(root.right != null){
            Mirror(root.right);
        }
    }

    // 2. 利用栈，每次把要从操作的节点交换后，再把左右子节点压入栈，重复操作

    public void Mirror1(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null||node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
    }
}
