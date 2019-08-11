package nowCoder;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BstConvertLinkedList_26 {

    // 1. 递归法
    //   1. 每次传入树的根，返回的是转化后的双向连链表的头部。
    ///  2. 将转化后的左子树和根和右子树合并成一体
    //   3. 递归的空的时候，直接返回即可
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return  null;

        TreeNode newHead = null;

        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode cur = leftHead;
        if(leftHead == null)
            newHead = pRootOfTree;
        else{
            newHead = leftHead;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
        }

        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return newHead;
    }
}
