package leetcode.john.easy.tree;

import leetcode.john.BinaryTree;
import leetcode.john.TreeNode;

public class InvertABinaryTree {
	public static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.left = right;
		root.right = left;
		return root;
    }
    
    public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(1); 
        tree1.insert(2); 
        tree1.insert(3); 
        tree1.insert(4); 
        tree1.insert(5); 
        
    	
}
