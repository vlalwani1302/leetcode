package leetcode.alice.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Pairs> queue = new LinkedList<Pairs>();
        int col = 0, row = 0;
        
        queue.add(new Pairs(root, col, row));
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        while(!queue.isEmpty()){
            Pairs pair = queue.poll();
            col = pair.col;
            row = pair.row;
            map.putIfAbsent(col, new ArrayList<int[]>());
            map.get(col).add(new int[]{pair.node.val, row});
            
            if(pair.node.left != null)
                queue.add(new Pairs(pair.node.left, col-1, row+1));
            if(pair.node.right != null)
                queue.add(new Pairs(pair.node.right, col+1, row+1));
            
        }
        
        map = map.entrySet().stream().sorted((k1,k2) -> k1.getKey().compareTo(k2.getKey())).
            collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2) ->
                                    e1, LinkedHashMap::new));
        
        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
        for(Entry<Integer,List<int[]>> e : map.entrySet()){
            List<int[]> list = e.getValue();
            Collections.sort(list, ((a1,a2) -> a1[1] - a2[1]));
            
            List<Integer> l = new ArrayList<Integer>();
            for(int[] a : list) {
            	l.add(a[0]);
            }
            result.put(e.getKey(), l);
        }
        return result.values().stream().collect(Collectors.toList());
    }
}

class Pairs{
    public TreeNode node;
    public int col;
    public int row;
    
    public Pairs(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
}