package leetcode.alice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
class BSTIterator {
    Queue<Integer> queue = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        if(!queue.isEmpty()){
            return queue.poll();
        }
        return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!queue.isEmpty()){
            return true;
        }
        return false;
    }
    
    public void inorder(TreeNode node){
        if(node == null){
            return ;
        }
        
        inorder(node.left);
        queue.add(node.val);
        inorder(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */