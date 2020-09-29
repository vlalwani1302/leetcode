package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

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
    static List<Integer> rightside = new ArrayList();
    
    public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(2);
		bt.insert(4);
		bt.insert(7);
		bt.insert(8);
		bt.insert(10);

		System.out.println(rightSideView(bt.root));
	}
    
    public static void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
}