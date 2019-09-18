package LeetCode.Tree;

import LeetCode.Common.Node;

import java.util.LinkedList;
import java.util.List;

public class P559_maxDepth {
    public int maxDepth(Node root) {
        int maxDepth = 0;
        maxDepth = maxDepthRc(root);
        return maxDepth;
    }

    private int maxDepthRc(Node root){
        if(root == null) return 0;
        int depth = 1;
        if(root.children == null || root.children.size() == 0) return depth;
        else{
            for(Node node:root.children){
                depth = Math.max(maxDepthRc(node),depth);
            }
            return depth + 1;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new LinkedList<>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);
        node1.children = list1;
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list2 = new LinkedList<>();
        list2.add(node5);
        list2.add(node6);
        node3.children = list2;

        P559_maxDepth solver = new P559_maxDepth();
        System.out.println(solver.maxDepth(node1));
    }
}


