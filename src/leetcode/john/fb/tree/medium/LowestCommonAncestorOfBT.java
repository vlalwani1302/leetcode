package leetcode.john.fb.tree.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.john.BinaryTree;
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
public class LowestCommonAncestorOfBT {
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
        	return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
        	return root;
        }
        return left != null? left : right;
    }
    
	public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(5); 
    	tree1.insert(3); 
        tree1.insert(6);
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(4);
    	
    }

}