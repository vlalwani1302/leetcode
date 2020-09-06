package leetcode.alice.BinaryTree;

import java.util.Stack;

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        
        if(root == null)
            return true;
        while(curr != null || !stack.isEmpty()){
            if(curr == null){
                curr = stack.pop();
                if(prev != null && curr.val <= prev.val){
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }else{
                stack.push(curr);
                curr = curr.left;
            }
        }
        return true;
        //return isBST(root, null, null);
    }
    
    /*public boolean isBST(TreeNode node, Integer lower, Integer upper){
        if(node == null)
            return true;
        
        int val = node.val;
        if(lower != null && val <= lower)
            return false;
        if(upper != null && val >= upper)
            return false;
        if(!isBST(node.right,val,upper))
            return false;
        if(!isBST(node.left,lower,val))
            return false;
        return true;
    }*/
}