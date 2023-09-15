package com.sophia.blind75.tree;


import javax.swing.tree.TreeNode;

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
public class BTMaxSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        //base case
        if(root == null) return 0;
        //left
        int leftMax = Math.max(dfs(root.left),0);
        //right
        int rightMax = Math.max(dfs(root.right),0);
        //update max

        max = Math.max(max,leftMax+rightMax + root.val);

        return Math.max(leftMax,rightMax)+root.val;
    }
}