package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
class ClosestBinarySearchTree {
    int closest;
	List<Integer> nums = new ArrayList<Integer>();

    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        return binarySearch(root, target);
    }
    
    public int binarySearch(TreeNode node, double target) {
        if(node == null){
            return closest;
        }
        int val = node.val;
        closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
        if(target < node.val){
            binarySearch(node.left, target);
        }else{
            binarySearch(node.right, target);
        }
        return closest;
    }
    
    public int closestValue1(TreeNode root, double target) {
        inorder(root);
        return Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
          });
    }
    
    public void inorder(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	inorder(node.left);
    	nums.add(node.val);
    	inorder(node.right);
    }
}