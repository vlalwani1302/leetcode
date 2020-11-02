package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;
        
        Queue<Pair> queue = new LinkedList<Pair>();
        String connector = "->";

        queue.add(new Pair(root, new StringBuilder(String.valueOf(root.val))));
        
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            TreeNode current = pair.node;
            StringBuilder path = pair.paths;
            
            if(current.left == null && current.right == null){
                result.add(path.toString());
                continue;
            }
            if(current.left != null){
                StringBuilder leftPath = new StringBuilder(path);
                leftPath.append(connector);
                leftPath.append(String.valueOf(current.left.val));
                queue.add(new Pair(current.left, leftPath));
            }
            if(current.right != null){
                StringBuilder rightPath = new StringBuilder(path);

                rightPath.append(connector);
                rightPath.append(String.valueOf(current.right.val));
                queue.add(new Pair(current.right, rightPath));
            }
        }
            
        return result;
        
    }
    
    class Pair{
        public TreeNode node;
        public StringBuilder paths;
        
        public Pair(TreeNode node, StringBuilder paths){
            this.node = node;
            this.paths = paths;
        }
    }
}