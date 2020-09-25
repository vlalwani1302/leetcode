package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

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
class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> columnMap = new HashMap<Integer, List<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        
        int col = 0;
        queue.add(new Pair(root, col));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            col = pair.column;
            if(pair.node != null){
                if(!columnMap.containsKey(pair.column)){
                    columnMap.put(pair.column, new ArrayList<Integer>());
                }
                columnMap.get(pair.column).add(pair.node.val);
                
                queue.add(new Pair(pair.node.left, col -1));
                queue.add(new Pair(pair.node.right, col +1));

            }
        }
        
        columnMap = columnMap.entrySet().stream().sorted((k1,k2) -> k1.getKey().compareTo(k2.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        return columnMap.values().stream().collect(Collectors.toList());
    }
}

class Pair{
    public TreeNode node;
    public Integer column;
    
    public Pair(TreeNode node, Integer column){
        this.node = node;
        this.column = column;
    }
}