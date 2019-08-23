package LeetCode.DP;

import LeetCode.Common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class P337_rob3 {

    // 1. 递归法
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        if(root.left == null){
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        }else if(root.right == null){
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        }else{
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right)
                    + rob(root.right.left) + rob(root.right.right), rob(root.right) + rob(root.left));
        }
    }

    // 2. 记忆化递归
    public int rob1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();

        rob1Helper(root, map);
        int max = 0;
        for(Integer i:map.values()){
            max = Math.max(i, max);
        }
        return max;
    }
    private int rob1Helper(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            map.put(root, root.val);
            return root.val;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }else{
            if(root.left == null){
                int res = Math.max(rob1Helper(root.right, map),
                        rob1Helper(root.right.left,map) + rob1Helper(root.right.right, map) + root.val) ;
                map.put(root, res);
                return res;
            }
            else if(root.right == null){
                int res = Math.max(rob1Helper(root.left, map),
                        rob1Helper(root.left.left,map) + rob1Helper(root.left.right, map) +root.val);
                map.put(root, res);
                return res;
            }else{
                int res =  Math.max(rob1Helper(root.right,map) + rob1Helper(root.left, map),
                        rob1Helper(root.left.left,map) + rob1Helper(root.left.right, map)
                                + rob1Helper(root.right.left,map) + rob1Helper(root.right.right, map) + root.val);
                map.put(root, res);
                return res;
            }

        }
    }

    // 3. 动态规划
    public int rob2(TreeNode root) {
        int[] res = new int[2];
        res = rob2Helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] rob2Helper(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;
        int[] left = rob2Helper(root.left);
        int[] right = rob2Helper(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[1], left[0])
                + Math.max(right[1],right[0]);
        return res;
    }
}
