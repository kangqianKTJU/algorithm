package nowCoder;

import java.util.Stack;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree_17 {

    // 1. 递归
    //    1. 判断两个树的根节点是否相等，相等的话，继续判断左右子数的根节点是否相等，直到B树为null
    //    2. 分别判断该子树，该子树的左右子数是否包含该子结构的树。
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;

        return topEqualTree(root1, root2) || topEqualTree(root1.left, root2) || topEqualTree(root1.right, root2);
    }

    private boolean topEqualTree(TreeNode node1, TreeNode node2){
        if(node2 == null) return true;
        if(node1 == null) return false;
        if(node1.val == node2.val) return false;
        return topEqualTree(node1.left, node2.left) && topEqualTree(node1.right, node2.right);
    }


}
