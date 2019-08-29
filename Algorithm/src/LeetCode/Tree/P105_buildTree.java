package LeetCode.Tree;

import InterviewPractice.LevelTraverse;
import LeetCode.Common.TreeNode;

import javax.xml.transform.SourceLocator;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class P105_buildTree {

    // 1. 递归构建二叉树
    //      1. 先序遍历的第一个元素就是构建的二叉树的根节点
    //      2. 找到中序遍历中根节点的位置，根节点左边的未左子树的节点中序遍历结果，右边的右子树的节点中序遍历结果
    //      3. 根据左子树、右子树的数目在先序遍历中找到对应的先序结果，对左右子树递归调用这个过程。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0, preorder.length - 1, inorder, 0 , inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int lowPre, int highPre, int[] inorder, int lowIn, int highIn){
        if(preorder == null || lowPre > highPre) return null;
        TreeNode head = new TreeNode(preorder[lowPre]);
        int index = lowIn;
        for (int i = lowIn; i <= highIn ; i++) {
            if(head.val == inorder[i]){
                index = i;
                break;
            }
        }
        int interval = index - lowIn;
        TreeNode left = buildTree(preorder,lowPre + 1, lowPre + interval, inorder, lowIn, index - 1);
        TreeNode right = buildTree(preorder, lowPre + interval + 1, highPre, inorder, index + 1, highIn);
        head.left = left;
        head.right = right;
        return head;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] intsOrder = new int[]{9,3,15,20,7};
        P105_buildTree solver = new P105_buildTree();
        TreeNode head = solver.buildTree(preOrder, intsOrder);
        LevelTraverse traverse = new LevelTraverse();
        traverse.levelTraverse(head);
    }
}
