package nowCoder;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;

public class FindPath_24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        find(root, target, res);
        return res;
    }

    public void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> res) {

        if (root == null) return;
        if (root.val == target && root.left == null && root.right == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        }else if (root.val != target) {
            if (root.left != null) {
                find(root.left, target - root.val, res);
                for (ArrayList list : res) {
                    list.add(0, root.val);
                }

            }
            if (root.right != null) {
                find(root.left, target - root.val, res);
                for (ArrayList list : res) {
                    list.add(0, root.val);
                }
            }
        }
    }

}
