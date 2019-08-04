package nowCoder;

import sun.reflect.generics.tree.Tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree_4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre, in,0 ,pre.length - 1,0 ,in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in, int lowPre ,int highPre, int lowIn, int highIn) {
        if(highPre < lowPre) return null;
        if(in.length == 1) return new TreeNode(pre[lowPre]);

        TreeNode rootNode = null;
        int rootVal = pre[lowPre];
        for(int i = lowIn; i <= highIn; i++){
            if(in[i] == rootVal){
                rootNode = new TreeNode(rootVal);
                rootNode.left = reConstructBinaryTree(pre, in ,
                        lowPre + 1,lowPre + i - lowIn,
                        lowIn, i - 1);
                rootNode.right= reConstructBinaryTree(pre, in ,
                        lowPre + i - lowIn + 1, highPre,
                        i + 1, highIn);
                break;
            }
        }
        return rootNode;
    }
}
