package leetcode.john.easy;

import leetcode.john.BinaryTree;
import leetcode.john.TreeNode;

public class MaxDepthTree {
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.getLeft()) + 1, 
				maxDepth(root.getRight()) + 1);
    }
    
    public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(1); 
        tree1.insert(2); 
        tree1.insert(3); 
        tree1.insert(4); 
        tree1.insert(5); 
        
    	
    	System.out.println(maxDepth(tree1.getRoot()));
    }
}
