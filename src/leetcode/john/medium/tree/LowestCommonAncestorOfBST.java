package leetcode.john.medium.tree;

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
public class LowestCommonAncestorOfBST {
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<=root.val && root.val<=q.val 
        		|| p.val>=root.val && root.val>=q.val) {
        	return root; // root lies between p and q(i.e between left right subtree) hence lowest common ancestor
        }
        else if(p.val<root.val && q.val<root.val) {// p,q in left subtree
        	return lowestCommonAncestor(root.left, p, q);
        }
        else {// p,q in right subtree
        	return lowestCommonAncestor(root.right, p, q);
        }
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