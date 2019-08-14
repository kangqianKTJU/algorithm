package LeetCode.DFS;

import LeetCode.Common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class P101_isSymmetric {

    // 1. 递归法
    //  两颗二叉树是否镜像对称，只要看其对应的左右子树的根节点是否相同即可，然后看其左子树的右孩子是否和右子树的左孩子相等。
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }


    //2. 迭代法
    // 对称的节点的右节点和另一个节点的左节点也是对称的，比较完对称节点后，只要把对称节对的对称子节点紧挨着如队列即可。
    public boolean isSymmetric1(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val  != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        P101_isSymmetric solution = new P101_isSymmetric();
        System.out.println(solution.isSymmetric1(node0));

    }

}
