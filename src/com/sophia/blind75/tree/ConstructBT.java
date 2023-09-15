package com.sophia.blind75.tree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class ConstructBT {

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



    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int[] preorder_arr;
        int[] inorder_arr;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //Define variables
            preorder_arr = preorder;
            inorder_arr = inorder;
            //Define the table
            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            //Pass the boundaries
            return dfs(0, inorder.length - 1);
        }
        private TreeNode dfs(int left, int right){
            int curVal = preorder_arr[index++];
            int curIdx = map.get(curVal);
            //Build current node
            TreeNode root = new TreeNode(curVal);

            //Build left subtree
            if(left < curIdx){
                root.left = dfs(left, curIdx - 1);
            }
            //Build right subtree
            if(curIdx < right){
                root.right = dfs(curIdx + 1, right);
            }
            //Return current root node
            return root;
        }
    }
//        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
//
//        for (int i = 0; i < inOrder.length; i++)
//            inOrderIndexMap.put(inOrder[i], i);
//
//        return splitTree(preOrder, inOrderIndexMap,
//                0, 0, inOrder.length - 1);
//    }
//
//    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
//                               int rootIndex, int left, int right) {
////create tree root = 3
//        TreeNode root = new TreeNode(preOrder[rootIndex]);
////[9],3,[15,20,7]
//        // Create left and right subtree
//        int mid = inOrderIndexMap.get(preOrder[rootIndex]);//mid ->index
//        if (mid > left)
//            root.left = splitTree(preOrder, inOrderIndexMap,
//                    rootIndex + 1, left, mid - 1);
//        if (mid < right)
//            root.right = splitTree(preOrder, inOrderIndexMap,
//                    rootIndex + mid - left + 1, mid + 1, right);
//        return root;
//    }
//
//}
//mid - left + 1: This part calculates the number of nodes in the left subtree. mid is the index of the current root node in the in-order traversal, and left is the index of the left boundary of the current subarray.
//        Subtracting left from mid gives you the count of nodes in the left subtree.
//        rootIndex + mid - left + 1: This calculation adds the number of nodes in the left subtree to the index of the current root node. This effectively brings you to the starting index of the right subtree's pre-order traversal.
//
//        So, this calculation ensures that you start building the right subtree in the pre-order traversal from the correct index, accounting for the nodes already covered by the left subtree.