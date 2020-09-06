package leetcode.john.easy;

import leetcode.john.BinaryTree;
import leetcode.john.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
        	return true;
        }
        else if((p==null && q!=null) || (q==null && p!=null)) {
        	return false;
        }
        else if(p.getVal() != q.getVal()) {
        	return false;
        }
        else {
        	return isSameTree(p.getLeft(), q.getLeft()) && 
        			isSameTree(p.getRight(), q.getRight());
        }
    }
    
    public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(1); 
        tree1.insert(2); 
        tree1.insert(3); 
        
    	BinaryTree tree2 = new BinaryTree();
    	tree2.insert(1); 
    	tree2.insert(2); 
    	tree2.insert(3);
    	
    	BinaryTree tree3 = new BinaryTree();
    	tree2.insert(1); 
    	tree2.insert(3); 
    	tree2.insert(2);
    	
    	System.out.println("Tree1 and Tree2");
    	System.out.println(isSameTree(tree1.getRoot(), tree2.getRoot()));
    	System.out.println("Tree1 and Tree3");
    	System.out.println(isSameTree(tree1.getRoot(), tree3.getRoot()));
    }
}
