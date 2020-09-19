package leetcode.john.fb.tree.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.john.TreeNode;

/* Q 173
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
		
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
public class BSTIterator {
	Queue<TreeNode> queue = new LinkedList<>();
	
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		queue.add(root);
		inorder(root.right);
	}

	/** @return the next smallest number */
    public int next() {
        return queue.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
