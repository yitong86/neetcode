package com.sophia.blind75.tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    public int maxDepth(TreeNode root) {


        if (root == null)
            return 0;

        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        int levels = 0;

        while (!nodes.isEmpty()) {

            levels++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = nodes.poll();
                if (poppedNode.left != null) nodes.add(poppedNode.left);
                if (poppedNode.right != null) nodes.add(poppedNode.right);
            }

        }

        return levels;
    }
}