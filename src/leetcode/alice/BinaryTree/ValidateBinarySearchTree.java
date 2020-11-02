package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.List;
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
    
    public boolean isValidBSTUsingInorder(TreeNode root) {
        
        List<Integer> list = inorder(root, new ArrayList<Integer>());
        for(int i=0; i<list.size() -1; i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> inorder(TreeNode node, List<Integer> list) {
        if(node == null) return list;
        
        inorder(node.left, list);
        
        list.add(node.val);
        inorder(node.right, list);
        
        return list;
    }
}