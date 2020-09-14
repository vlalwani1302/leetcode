package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> result = lowestCommonAncestorHelper(root, p, q, new ArrayList<TreeNode>());
        
        TreeNode min = result.get(0);
        for(int i=1; i < result.size(); i++){
            if(min.val > result.get(i).val){
                min = result.get(i);
            }
        }
                return min;

    }
    
    public List<TreeNode> lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> result) {
        if(root == null){
            return result;
        }
        if(p.val > root.val && q.val > root.val){
            lowestCommonAncestorHelper(root.right, p, q, result);
        }else if(p.val < root.val && q.val < root.val){
            lowestCommonAncestorHelper(root.left, p, q, result);
        }else{
            result.add(root);
        }
        return result;
    }
}