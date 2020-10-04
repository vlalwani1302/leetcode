package leetcode.john.fb.tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.alice.BinaryTree.BinaryTree;
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
class BinaryTreeRightSide {
    public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(2);
		bt.insert(4);
		bt.insert(7);
		bt.insert(8);
		bt.insert(10);

	}
    
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightside = new ArrayList<Integer>();
        if(root == null) {
        	return rightside;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i=0; i< size; i++) {
        		TreeNode current = queue.remove();
        		if(i == size-1) {// rightmost value in queue for that level
        			rightside.add(current.val);
        		}
        		if(current.left != null) {
        			queue.add(current.left);
        		}
        		if(current.right != null) {
        			queue.add(current.right);
        		}
        	}
        }
		return rightside;
    }
}