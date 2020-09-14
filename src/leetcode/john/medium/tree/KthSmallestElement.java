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
public class KthSmallestElement {
	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list, k);
		
		return list.get(k-1);
    }
    
    
    public static void inorderTraversal(TreeNode root, List<Integer> list, int k) {
		if(root == null) {
			return;
		}
		inorderTraversal(root.left, list, k);
		if(list.size()+1 == k) {
			list.add(root.val);
			return;
		}else {
			list.add(root.val);
		}
		inorderTraversal(root.right, list, k);
	}

	public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(5); 
    	tree1.insert(3); 
        tree1.insert(6);
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(4);
        
    	
    	System.out.println(kthSmallest(tree1.getRoot(), 2));
    }

}