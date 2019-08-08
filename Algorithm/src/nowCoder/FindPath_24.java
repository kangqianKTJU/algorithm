package nowCoder;


import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath_24 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Find(root,target);
        return res;
    }

    // 1.递归法
    // 1. 因此要记录完整的访问路径，所以需要一个记忆路径的ArrayList
    // 2. 每次访问到某个节点时，将其值存储到path中，如果该值是叶子节点，且val等于传入的arget,则说明一路遍历下来存储的
    //    节点的值之和等于tareget.就记录小的储存到res容器中
    // 3. 若不满足，分别调用左右子数，不用自己处理，等他遍历的叶子节点的时候自己处理。因为不满足则返回上一级调用，
    // 满足的话同步骤2
    // 最后，将root.val从path中弹出，返回他的父亲节点，遍历他的兄弟子数。直到遍历完树。
    private void Find(TreeNode root,int target){
        if(root == null) return;

        path.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            ArrayList<Integer> realPath = new ArrayList<>();
            realPath.addAll(path);
            res.add(realPath);
        }
        Find(root.left,target - root.val);
        Find(root.right,target - root.val);
        path.remove(path.size() - 1);
    }
}
