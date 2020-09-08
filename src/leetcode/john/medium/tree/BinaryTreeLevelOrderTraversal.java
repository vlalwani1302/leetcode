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
class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        createList(root, lists, 0);
        return lists;
    }
    
    public static void createList(TreeNode root, List<List<Integer>> lists, Integer level){
        if(root == null)
            return;
        
        List<Integer> list = null;
        if(lists.size() == level){
            list = new ArrayList<Integer>();
            
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root.getVal());
        createList(root.getLeft(), lists, level+1);
        createList(root.getRight(), lists, level+1);

    }
    
    public static void main(String[] args) {
    	BinaryTree tree1 = new BinaryTree();
    	tree1.insert(3); 
    	tree1.insert(9); 
        tree1.insert(20);
        tree1.insert(15);
        tree1.insert(7);
        
    	
    	System.out.println(levelOrder(tree1.getRoot()));
    }

}