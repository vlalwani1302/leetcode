package leetcode.john.fb.tree.easy;

import leetcode.john.TreeNode;

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
class ClosestBinarySearchTree {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        int val;
        while(root != null) {
        	val = root.val;
        	closest = Math.abs(val-target) < Math.abs(closest-target) ? val : closest;
        	if(target > val) {
        		root = root.right;
        	}else {
        		root = root.left;
        	}
        }
        return closest;
    }
    
}