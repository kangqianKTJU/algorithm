package nowCoder;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/**
 * 1. 若pNode的右子数不为空，则返回右子树中最左的节点
 * 2. pNode的右子树为空：
 *      3. 若pNode 是其父节点的左节点，返回父节点
 *      4. 若pNode 是其父节点的右节点，则看其父节点的父节点
 *          5. 若父节点的父节点为null或者父节点是父节点的父节点的右节点，则返回null ,否则返回父节点的父节点
 *
  */

public class GetNextTreeNode_57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if(pNode == null) return pNode;
        if(pNode.right != null){
            TreeLinkNode res = pNode.right;
            while(res.left != null){
                res = res.left;
            }
            return res;
        }
        TreeLinkNode node = pNode;
        while(node.next != null){
            if(node.next.left == node){
                return node.next;
            }
            node = node.next;
        }
        return null;
    }
}
