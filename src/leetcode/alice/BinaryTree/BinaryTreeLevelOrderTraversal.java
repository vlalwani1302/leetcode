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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        createList(root, lists, 0);
        return lists;
    }
    
    public void createList(TreeNode root, List<List<Integer>> lists, Integer level){
        if(root == null)
            return;
        
        List<Integer> list = null;
        if(lists.size() == level){
            list = new ArrayList<Integer>();
            
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root.val);
        createList(root.left, lists, level+1);
        createList(root.right, lists, level+1);

    }

}