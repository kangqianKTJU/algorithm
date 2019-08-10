package nowCoder;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintTreeZ_59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(pRoot == null) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.addLast(pRoot);

        while (stack.size() != 0){
            TreeNode temp = stack.getFirst();

        }
    }
}
