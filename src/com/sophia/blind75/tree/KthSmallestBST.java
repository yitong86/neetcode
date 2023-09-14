package com.sophia.blind75.tree;


import javax.swing.tree.TreeNode;
import java.util.Stack;
//1,create am empty stack s
//2 initialize current node as roo
//3 push the current node to s and set current = current->left until current is nul
//4 if current is null and stack is not empty then
//a pop the top item from stack
//b print the poped item, set current - popped_item->right
//c go to step3
//5 if current is null and stack is empty then wer are doen
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

public class KthSmallestBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
    }
}