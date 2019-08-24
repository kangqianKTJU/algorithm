package LeetCode.Tree;
/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */

import LeetCode.Common.TreeNode;

public class P108_sortedArrayToBST {

    // 1. 递归
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return sortedArrayToBSTRc(nums, 0, nums.length - 1);
    }

    // 返回数组中从 low 到 high下标元素组成的 BST
    private TreeNode sortedArrayToBSTRc(int[] nums, int low, int high) {
        // 1. 递归终止条件
        if(low > high) return null;
        // 2. 生成BST的头节点
        int mid = low + (high - low) / 2;
        TreeNode newHead = new TreeNode(nums[mid]);
        // 3. 递归，拼接左子树和右子树返回的BST
        newHead.left = sortedArrayToBSTRc(nums, low, mid - 1);
        newHead.right = sortedArrayToBSTRc(nums, mid + 1, high);

        return newHead;
    }

    // 2. 辅助栈




}
