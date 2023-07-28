package com.sophia.blind75.tree;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

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
public class InvertTree {

    TreeNode invertTreeRecursive(TreeNode root) {

        if (root == null)
            return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
       //start with the first root node
        queue.add(root);
//run a loop till this queue is not empty
        while (!queue.isEmpty()) {
            //remove leaste node
            final TreeNode node = queue.poll();

            // Swap nodes
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add left and right of this node to the queue
            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

}