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
class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<Integer>();
            arr = inorder(root, arr);
        
        return arr.get(k-1);
    }
    
    List<Integer> inorder(TreeNode root, List<Integer> arr ){
        if(root == null){
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        
        return arr;
    }
}